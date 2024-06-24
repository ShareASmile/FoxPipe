package org.schabi.newpipelegacy;

import android.content.Context;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.schabi.newpipe.extractor.downloader.Downloader;
import org.schabi.newpipe.extractor.downloader.Request;
import org.schabi.newpipe.extractor.downloader.Response;
import org.schabi.newpipe.extractor.exceptions.ReCaptchaException;
import org.schabi.newpipelegacy.util.CookieUtils;
import org.schabi.newpipelegacy.util.InfoCache;
import org.schabi.newpipelegacy.util.OkHttpTlsHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;


public final class DownloaderImpl extends Downloader {
    public static final String USER_AGENT
            = "Mozilla/5.0 (Windows NT 10.0; rv:91.0) Gecko/20100101 Firefox/91.0";
    public static final String YOUTUBE_RESTRICTED_MODE_COOKIE_KEY
            = "youtube_restricted_mode_key";
    public static final String YOUTUBE_RESTRICTED_MODE_COOKIE = "PREF=f2=8000000";
    public static final String YOUTUBE_DOMAIN = "youtube.com";

    private static DownloaderImpl instance;
    private Map<String, String> mCookies;
    private OkHttpClient client;

    private DownloaderImpl(final OkHttpClient.Builder builder) {
        OkHttpTlsHelper.enableModernTLS(builder);
        this.client = builder
                .readTimeout(30, TimeUnit.SECONDS)
//                .cache(new Cache(new File(context.getExternalCacheDir(), "okhttp"),
//                        16 * 1024 * 1024))
                .build();
        this.mCookies = new HashMap<>();
    }

    /**
     * It's recommended to call exactly once in the entire lifetime of the application.
     *
     * @param builder if null, default builder will be used
     * @return a new instance of {@link DownloaderImpl}
     */
    public static DownloaderImpl init(@Nullable final OkHttpClient.Builder builder) {
        instance = new DownloaderImpl(
                builder != null ? builder : new OkHttpClient.Builder());
        return instance;
    }

    public static DownloaderImpl getInstance() {
        return instance;
    }

    public String getCookies(final String url) {
        List<String> resultCookies = new ArrayList<>();
        if (url.contains(YOUTUBE_DOMAIN)) {
            String youtubeCookie = getCookie(YOUTUBE_RESTRICTED_MODE_COOKIE_KEY);
            if (youtubeCookie != null) {
                resultCookies.add(youtubeCookie);
            }
        }
        // Recaptcha cookie is always added TODO: not sure if this is necessary
        String recaptchaCookie = getCookie(ReCaptchaActivity.RECAPTCHA_COOKIES_KEY);
        if (recaptchaCookie != null) {
            resultCookies.add(recaptchaCookie);
        }
        return CookieUtils.concatCookies(resultCookies);
    }

    public String getCookie(final String key) {
        return mCookies.get(key);
    }

    public void setCookie(final String key, final String cookie) {
        mCookies.put(key, cookie);
    }

    public void removeCookie(final String key) {
        mCookies.remove(key);
    }

    public void updateYoutubeRestrictedModeCookies(final Context context) {
        String restrictedModeEnabledKey =
                context.getString(R.string.youtube_restricted_mode_enabled);
        boolean restrictedModeEnabled = PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(restrictedModeEnabledKey, false);
        updateYoutubeRestrictedModeCookies(restrictedModeEnabled);
    }

    public void updateYoutubeRestrictedModeCookies(final boolean youtubeRestrictedModeEnabled) {
        if (youtubeRestrictedModeEnabled) {
            setCookie(YOUTUBE_RESTRICTED_MODE_COOKIE_KEY,
                    YOUTUBE_RESTRICTED_MODE_COOKIE);
        } else {
            removeCookie(YOUTUBE_RESTRICTED_MODE_COOKIE_KEY);
        }
        InfoCache.getInstance().clearCache();
    }

    /**
     * Get the size of the content that the url is pointing by firing a HEAD request.
     *
     * @param url an url pointing to the content
     * @return the size of the content, in bytes
     */
    public long getContentLength(final String url) throws IOException {
        try {
            final Response response = head(url);
            return Long.parseLong(response.getHeader("Content-Length"));
        } catch (NumberFormatException e) {
            throw new IOException("Invalid content length", e);
        } catch (ReCaptchaException e) {
            throw new IOException(e);
        }
    }

    public InputStream stream(final String siteUrl) throws IOException {
        try {
            final okhttp3.Request.Builder requestBuilder = new okhttp3.Request.Builder()
                    .method("GET", null).url(siteUrl)
                    .addHeader("User-Agent", USER_AGENT);

            String cookies = getCookies(siteUrl);
            if (!cookies.isEmpty()) {
                requestBuilder.addHeader("Cookie", cookies);
            }

            final okhttp3.Request request = requestBuilder.build();
            final okhttp3.Response response = client.newCall(request).execute();
            final ResponseBody body = response.body();

            if (response.code() == 429) {
                throw new ReCaptchaException("reCaptcha Challenge requested", siteUrl);
            }

            if (body == null) {
                response.close();
                return null;
            }

            return body.byteStream();
        } catch (ReCaptchaException e) {
            throw new IOException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Response execute(@NonNull final Request request)
            throws IOException, ReCaptchaException {
        final String httpMethod = request.httpMethod();
        final String url = request.url();
        final Map<String, List<String>> headers = request.headers();
        final byte[] dataToSend = request.dataToSend();

        RequestBody requestBody = null;
        if (dataToSend != null) {
            requestBody = RequestBody.create(null, dataToSend);
        }

        final okhttp3.Request.Builder requestBuilder = new okhttp3.Request.Builder()
                .method(httpMethod, requestBody).url(url)
                .addHeader("User-Agent", USER_AGENT);

        String cookies = getCookies(url);
        if (!cookies.isEmpty()) {
            requestBuilder.addHeader("Cookie", cookies);
        }

        for (Map.Entry<String, List<String>> pair : headers.entrySet()) {
            final String headerName = pair.getKey();
            final List<String> headerValueList = pair.getValue();

            if (headerValueList.size() > 1) {
                requestBuilder.removeHeader(headerName);
                for (String headerValue : headerValueList) {
                    requestBuilder.addHeader(headerName, headerValue);
                }
            } else if (headerValueList.size() == 1) {
                requestBuilder.header(headerName, headerValueList.get(0));
            }

        }

        final okhttp3.Response response = client.newCall(requestBuilder.build()).execute();

        if (response.code() == 429) {
            response.close();

            throw new ReCaptchaException("reCaptcha Challenge requested", url);
        }

        final ResponseBody body = response.body();
        String responseBodyToReturn = null;

        if (body != null) {
            responseBodyToReturn = body.string();
        }

        final String latestUrl = response.request().url().toString();
        return new Response(response.code(), response.message(), response.headers().toMultimap(),
                responseBodyToReturn, latestUrl);
    }
}
