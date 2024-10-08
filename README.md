![](cover.jpeg)

# auto-motion

[comment]: <> (![buildStatus]&#40;https://img.shields.io/github/workflow/status/theapache64/auto-motion/Java%20CI%20with%20Gradle?style=plastic&#41;)

[comment]: <> (![latestVersion]&#40;https://img.shields.io/github/v/release/theapache64/auto-motion&#41;)
<a href="https://twitter.com/theapache64" target="_blank">
<img alt="Twitter: theapache64" src="https://img.shields.io/twitter/follow/theapache64.svg?style=social" />
</a>

Under active development ⚠️

> A CLI to automate your video editing process

## ⛰️ Story

- [Read](https://dev.to/teamxenox/automotion-how-i-automated-my-video-editing-process-1i6c) how I automated my video editing process (includes a demo at the end)

## 🦿 Prerequisites

- JRE
- ffmpeg
- ffprob
- ffpb
- autosub

<!--
## 🛠 Installation

<details open="open">
<summary><b>Automatic Installation</b></summary> <br/>

Copy and paste below line into your terminal.

```shell script
wget "https://raw.githubusercontent.com/theapache64/auto-motion/master/install.sh" -q --show-progress -O install.sh && sh install.sh && source ~/.bashrc
```

</details>

<details>
<summary><b>Manual Installation</b></summary> <br/>

1. Download latest `jar`
   from [releases](https://github.com/theapache64/auto-motion/releases/latest/download/auto-motion.main.jar)
1. Run `java -jar auto-motion.main.jar`

</details>
-->

## ⌨️ Usage

```shell script
~$ auto-motion
```

<details>
<summary><b>Complete Usage</b></summary> <br/>

```
usage: auto-motion -v input.mp4 [-H] -V <arg> [-BGM <arg>] [-ST <arg>]
       [-VL <arg>] [-MTL <arg>] [-TLS <arg>] [-ID <arg>] [-CR <arg>] [-WM
       <arg>] [-IT <arg>] [-CT <arg>] [-IST <arg>] [-CST <arg>] [-F <arg>]
       [-HL <arg>] [-WMC <arg>] [-WMS <arg>] [-WMBG <arg>] [-WMBGO <arg>]
       [-TFS <arg>] [-STFS <arg>] [-TC <arg>] [-STC <arg>] [-BG <arg>]
       [-RSRT <arg>] [-DSRT] [-RFMPG] [-sf] [-KS]
A tool to edit your lengthy screen records, automatically. Version :
v1.0.0-beta01
 -H,--help                              To print help text
 -V,--video <arg>                       Video inputs (required at least
                                        one)
 -BGM,--background-music <arg>          Background music for timelapse.
                                        Default
                                        'lab/lost_in_time.m
                                        p3'
 -ST,--sub-title <arg>                  Intro sub title
 -VL,--video-lang <arg>                 Video language. Default 'en'
 -MTL,--min-tl-src-len <arg>            Minimum timelapse source length
                                        (in seconds). Default '2.0'
 -TLS,--timelapse-speed <arg>           Timelapse speed (must be < 1). 0.5
                                        = 2x speed, 0.25 = 4x. Default
                                        '0.25'
 -ID,--intro-duration <arg>             Intro duration (in seconds).
                                        Default '3.0'
 -CR,--credits-duration <arg>           Credits duration (in seconds).
                                        Default '2'
 -WM,--watermark <arg>                  Watermark text. Default
                                        (theapache64) (active username)
 -IT,--intro-title <arg>                Intro title. Default (theapache64)
                                        (active username)
 -CT,--credits-title <arg>              Credits title. Default 'Thank
                                        You!'
 -IST,--intro-sub-title <arg>           Intro sub title. Default 'Mar 05
                                        2020' (current date)
 -CST,--credits-sub-title <arg>         Credits sub title. Default
                                        (theapache64) (active username)
 -F,--font <arg>                        Font file path. Default
                                        'lab/komikax.ttf'
 -HL,--highlight <arg>                  Highlight of the video. Format
                                        'HH:mm:ss-ss' (from- to seconds).
                                        Eg:
                                        auto-motion -v input.mp4 -HL
                                        '00:01:00-5'
                                        Will highlight 5 seconds of clip
                                        from 00:01:00
 -WMC,--wm-color <arg>                  Watermark text color. Default
                                        'white'
 -WMS,--wm-size <arg>                   Watermark text size. Default '24'
 -WMBG,--wm-background-color <arg>      Watermark background color.
                                        Default 'black'
 -WMBGO,--wm-background-opacity <arg>   Watermark background opacity.
                                        Default '0.5'
 -TFS,--title-font-size <arg>           Title font size. Default '30'
 -STFS,--sub-title-font-size <arg>      Sub title font size. Default '15'
 -TC,--title-color <arg>                Title color. Default 'white'
 -STC,--sub-title-color <arg>           Sub title color. Default 'gray'
 -BG,--background-color <arg>           Background color. Default 'black'
 -RSRT,--raw-srt <arg>                  To cancel autosub usage and use
                                        passed SRT file for timelapse
                                        calculation
 -DSRT,--default-srt                    To cancel autosub usage and use
                                        default SRT of the input video
                                        file.
 -RFMPG,--raw-ffmpeg                    To use ffmpeg rather than ffpb
 -sf,--superfast                        To make the ffmpeg encodig preset
                                        to superfast
 -KS,--keep-sh                          To keep final shell script file
                                        (developer-option). Default false.
🎊 Happy automate!
```

</details>

## ⤴️ Update 

```shell script
wget "https://raw.githubusercontent.com/theapache64/auto-motion/master/update.sh" -q --show-progress -O update.sh && sh update.sh
```

## 🥼 Run tests

```shell script
./gradlew test
```


## ✍️ Author

👤 **theapache64**

* Twitter: <a href="https://twitter.com/theapache64" target="_blank">@theapache64</a>
* Email: theapache64@gmail.com

Feel free to ping me 😉

## 🤝 Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Open an issue first to discuss what you would like to change.
1. Fork the Project
1. Create your feature branch (`git checkout -b feature/amazing-feature`)
1. Commit your changes (`git commit -m 'Add some amazing feature'`)
1. Push to the branch (`git push origin feature/amazing-feature`)
1. Open a pull request

Please make sure to update tests as appropriate.

## ❤ Show your support

Give a ⭐️ if this project helped you!

<a href="https://www.patreon.com/theapache64">
  <img alt="Patron Link" src="https://c5.patreon.com/external/logo/become_a_patron_button@2x.png" width="160"/>
</a>

<a href="https://www.buymeacoffee.com/theapache64" target="_blank">
    <img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" width="160">
</a>

<a href="https://www.paypal.me/theapache64" target="_blank">
    <img src="https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif" alt="Donation" width="160">
</a>

## ☑️ TODO

- [ ] Release initial version of auto-motion

## 📝 License

```
Copyright © 2021 - theapache64

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

_This README was generated by [readgen](https://github.com/theapache64/readgen)_ ❤
