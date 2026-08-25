# Hallagram

<div align="center">

# ?? Hallagram
### Advanced, Privacy-Enhanced Telegram Client for Android

**Hallagram** is a modern, privacy-focused and high-performance fork of Telegram for Android built for anonymity, speed, and freedom.

[![GitHub license](https://img.shields.io/github/license/Memoarchik/Hallagram.svg)](./LICENSE)
[![Release](https://img.shields.io/github/v/release/Memoarchik/Hallagram?include_prereleases)](https://github.com/Memoarchik/Hallagram/releases)

</div>

---

## ? Key Features

### ?? Ghost Mode (Full Anonymity)
- **Don't Send Read Receipts:** Read chats and messages without marking them as read (no double checkmarks).
- **Hide Online Status:** Prevent Telegram from broadcasting your online presence while using the app.
- **Hide Typing Indicator:** Don't send "typing...", audio recording, or file upload status indicators.
- **Anonymous Story Viewing:** Watch stories anonymously without appearing in the viewer list.

### ? Download & Upload Speed Boost
- **Multi-Stream Download Booster:** Multiplies concurrent download connections and chunk sizes (Off / Fast / Ultra up to 12 parallel streams and 1 MB chunks) to maximize download speed.
- **High-Throughput Upload Booster:** Increases simultaneous upload packets (up to 16 streams & 8 MB buffer) for faster media sharing.

### ?? Content Freedom & Restrictions Bypass
- **Bypass "Restrict Saving Content":** Forward messages, copy text, and save media from private channels and groups that have saving disabled (`noforwards` bypass).
- **Universal Screenshot Unlock:** Disables Android's `FLAG_SECURE` to allow taking screenshots and screen recordings in Secret Chats, protected media, and private channels.

### ??? Core Privacy & De-Googling (FOSS Base)
- **100% De-Googled:** Zero Firebase or Google Play Services dependencies.
- **UnifiedPush Support:** Push notifications without Google tracking.
- **No Ads & No Trackers:** Pure, clean Telegram experience without telemetry or sponsored messages.

---

## ??? Building From Source

### Prerequisites
- Android NDK `r27c` (27.2.12479018)
- JDK 17+
- CMake, `gperf`

### Build Command (ARM64)
```bash
./gradlew assembleAfatFdArm64Debug
```
Or simply run `build.bat` on Windows.

---

## ?? License
This project is licensed under the **GNU General Public License v2/v3** (GPL) in compliance with the upstream Telegram for Android codebase.
