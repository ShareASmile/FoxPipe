<p align="center"><a href="https://newpipe.net"><img src="assets/new_pipe_icon_5.png" width="150"></a></p> 
<h2 align="center"><b>NewPipe_Legacy_Revo</b></h2>
<h3 align="center">NewPipeLegacy preunified & unified version with working NewPipeExtractor dependency.</h3>

<p align="center">
<a href="https://github.com/ShareASmile/NewPipe-Legacy-Revo/releases" alt="GitHub release"><img src="https://img.shields.io/github/release/ShareASmile/NewPipe-Legacy-Revo.svg" ></a>
<a href="https://www.gnu.org/licenses/gpl-3.0" alt="License: GPLv3"><img src="https://img.shields.io/badge/License-GPL%20v3-blue.svg"></a>
<a href="https://github.com/ShareASmile/NewPipe-Legacy-Revo/actions/workflows/ci.yml" alt="Build Status"><img src="https://github.com/ShareASmile/NewPipe-Legacy-Revo/actions/workflows/ci.yml/badge.svg"></a>
<a href="https://hosted.weblate.org/engage/newpipe/" alt="Translation Status"><img src="https://hosted.weblate.org/widgets/newpipe/-/svg-badge.svg"></a>
<a href="https://webchat.freenode.net/#newpipe" alt="IRC channel: #newpipe"><img src="https://img.shields.io/badge/IRC%20chat-%23newpipe-brightgreen.svg"></a>
<a href="https://www.bountysource.com/teams/newpipe" alt="Bountysource bounties"><img src="https://img.shields.io/bountysource/team/newpipe/activity.svg?colorB=cd201f"></a>
</p>
<hr>
<p align="center"><a href="#screenshots">Screenshots</a> &bull; <a href="#description">Description</a> &bull; <a href="#features">Features</a> &bull; <a href="#installation-and-updates">Installation and updates</a> &bull; <a href="#contribution">Contribution</a> &bull; <a href="#donate">Donate</a> &bull; <a href="#license">License</a></p>
<p align="center"><a href="https://github.com/ShareASmile/NewPipe-Legacy-Revo">Website</a> &bull; <a href="https://newpipe.net/blog/">Blog</a> &bull; <a href="https://newpipe.net/FAQ/">FAQ</a> &bull; <a href="https://newpipe.net/press/">Press</a></p>
<hr>

<b>WARNING: THIS IS A BETA VERSION, THEREFORE YOU MAY ENCOUNTER BUGS. IF YOU DO, OPEN AN ISSUE VIA OUR GITHUB REPOSITORY.</b>

<b>PUTTING NEWPIPE OR ANY FORK OF IT INTO THE GOOGLE PLAY STORE VIOLATES THEIR TERMS AND CONDITIONS.</b>

## Screenshots

[<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/shot_01.png" width=160>](fastlane/metadata/android/en-US/images/phoneScreenshots/shot_01.png)
[<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/shot_02.png" width=160>](fastlane/metadata/android/en-US/images/phoneScreenshots/shot_02.png)
[<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/shot_03.png" width=160>](fastlane/metadata/android/en-US/images/phoneScreenshots/shot_03.png)
[<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/shot_04.png" width=160>](fastlane/metadata/android/en-US/images/phoneScreenshots/shot_04.png)
[<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/shot_05.png" width=160>](fastlane/metadata/android/en-US/images/phoneScreenshots/shot_05.png)
[<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/shot_06.png" width=160>](fastlane/metadata/android/en-US/images/phoneScreenshots/shot_06.png)
[<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/shot_07.png" width=160>](fastlane/metadata/android/en-US/images/phoneScreenshots/shot_07.png)
[<img src="fastlane/metadata/android/en-US/images/phoneScreenshots/shot_10.png" width=160>](fastlane/metadata/android/en-US/images/phoneScreenshots/shot_10.png)
[<img src="fastlane/metadata/android/en-US/images/tenInchScreenshots/shot_11.png" width=405>](fastlane/metadata/android/en-US/images/tenInchScreenshots/shot_11.png)
[<img src="fastlane/metadata/android/en-US/images/tenInchScreenshots/shot_12.png" width=405>](fastlane/metadata/android/en-US/images/tenInchScreenshots/shot_12.png)

## Description
 This repository contains updated preunified [NewPipeLegacy-v0.19.8](https://github.com/TeamNewPipe/NewPipe-legacy/releases/tag/v0.19.8) & revived unified v0.21.2 of [tossj fork of NewPipeLegacy](https://github.com/tossj/NewPipe-legacy/tree/update-newpipe-extractor-0.21.1) with updated [NewPipeExtractor for Legacy Devices](https://github.com/ShareASmile/NewPipeExtractor) dependency.

The application itself heavily relies on the extractor component which is responsible for proper parsing of various video/audio streams, including Youtube site. The old NewPipe Legacy version 0.19.8 depends on old extractor version which is practically deprecated and can't handle current Youtube (and similar?) streams, thus rendering the application useless for daily use.

NewPipe Legacy version 0.19.8+ in this repository uses the updated version of NewPipeExtractor for legacy devices and resolves the forementioned issue, thus making it possible to use old NewPipe Legacy updated version 0.19.8 with bug fixes, features & support for SoundCloud, Bandcamp, media.ccc.de sites added for legacy devices along with updated extractor version. However v0.21.2+ is also available with Unified Player in toss branch. APK's for legacy devices on Ice Cream Sandwich (Android 4.0.1 – 4.0.4) has been available from Releases, but it has a very basic support, can be buggy.

You don't need a YouTube account to use NewPipe, it is a copylefted libre software.

## Motivation

Not so long ago, NewPipe project implemented a new UI elements for video streams. Personally, I didn't like that change. I wanted to keep using the old UI instead.

### Features

* Search videos
* Display general info about videos
* Watch YouTube videos
* Listen to YouTube videos
* Popup mode (floating player)
* Select streaming player to watch video with
* Make Personalised Playlists Locally on device
* Open a video in Kodi
* Show next/related videos
* Search YouTube in a specific language
* Watch/Block age restricted material
* Display general info about channels
* Search channels
* Watch videos from a channel
* Orbot/Tor support (not yet directly)
* 1080p/2K/4K support
* View history
* Subscribe to channels
* Search history
* Search/watch playlists
* Watch as enqueued playlists
* Enqueue videos
* Local playlists
* Subtitles
* Livestream support
* Show comments

### Supported Services

NewPipe supports multiple services. Our [docs](https://teamnewpipe.github.io/documentation/) provide more info on how a new service can be added to the app and the extractor. Please get in touch with us if you intend to add a new one. Currently supported services are:

* YouTube
* SoundCloud \[beta\]
* media.ccc.de \[beta\]
* PeerTube instances \[beta\]
* Bandcamp \[beta\]

<!-- Hidden span to keep old links compatible. -->
<span id="updates"></span>

## Installation and updates
You can install NewPipe Legacy Revo using one of the following methods:

 1. Download the APK from [Github Releases](https://github.com/ShareASmile/NewPipe-Legacy-Revo/releases) and install it.
 2. Build a debug APK yourself. This is the fastest way to get new features on your device, but is much more complicated, so we recommend using one of the other methods.

## Contribution
Whether you have ideas, translations, design changes, code cleaning, or real heavy code changes, help is always welcome.
The more is done the better it gets!

If you'd like to get involved, check our [contribution notes](.github/CONTRIBUTING.md).

<a href="https://hosted.weblate.org/engage/newpipe/">
<img src="https://hosted.weblate.org/widgets/newpipe/-/287x66-grey.png" alt="Translation status" />
</a>

## Donate
If you like NewPipe we'd be happy about a donation. You can either send bitcoin or donate via Bountysource or Liberapay. For further info on donating to NewPipe, please visit our [upstream](https://newpipe.net/donate).

<table>
  <tr>
    <td><img src="https://bitcoin.org/img/icons/logotop.svg" alt="Bitcoin"></td>
    <td><img src="assets/bitcoin_qr_code.png" alt="Bitcoin QR code" width="100px"></td>
    <td><samp>16A9J59ahMRqkLSZjhYj33n9j3fMztFxnh</samp></td>
  </tr>
  <tr>
    <td><a href="https://liberapay.com/TeamNewPipe/"><img src="https://upload.wikimedia.org/wikipedia/commons/2/27/Liberapay_logo_v2_white-on-yellow.svg" alt="Liberapay" width="80px" ></a></td>
    <td><a href="https://liberapay.com/TeamNewPipe/"><img src="assets/liberapay_qr_code.png" alt="Visit NewPipe at liberapay.com" width="100px"></a></td>
    <td><a href="https://liberapay.com/TeamNewPipe/donate"><img src="assets/liberapay_donate_button.svg" alt="Donate via Liberapay" height="35px"></a></td>
  </tr>
  <tr>
    <td><a href="https://www.bountysource.com/teams/newpipe"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/22/Bountysource.png/320px-Bountysource.png" alt="Bountysource" width="190px"></a></td>
    <td><a href="https://www.bountysource.com/teams/newpipe"><img src="assets/bountysource_qr_code.png" alt="Visit NewPipe at bountysource.com" width="100px"></a></td>
    <td><a href="https://www.bountysource.com/teams/newpipe/issues"><img src="https://img.shields.io/bountysource/team/newpipe/activity.svg?colorB=cd201f" height="30px" alt="Check out how many bounties you can earn."></a></td>
  </tr>
</table>

## Privacy Policy

The NewPipe project aims to provide a private, anonymous experience for using media web services.
Therefore, the app does not collect any data without your consent. NewPipe's privacy policy explains in detail what data is sent and stored when you send a crash report, or comment in our blog. You can find the document [here](https://newpipe.net/legal/privacy/).

## License
[![GNU GPLv3 Image](https://www.gnu.org/graphics/gplv3-127x51.png)](https://www.gnu.org/licenses/gpl-3.0.en.html)  

NewPipe is Free Software: You can use, study share and improve it at your
will. Specifically you can redistribute and/or modify it under the terms of the
[GNU General Public License](https://www.gnu.org/licenses/gpl.html) as
published by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.  
