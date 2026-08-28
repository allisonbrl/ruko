# 📱 Ruko

> **Clean your camera roll in an oddly fun way** 🎯

<div align="center" style="background:black">

<img src="demo/screenshot.png" alt="Ruko App" style="height:600px; border-radius: 2rem; margin-top: 5rem; border:2px solid rgba(255, 255, 255, 0.3);">

<br><br>


<p>
  <a href="https://flutter.dev"><img src="https://img.shields.io/badge/Flutter-3.3+-blue?logo=flutter" alt="Flutter"></a>
  <a href="https://dart.dev"><img src="https://img.shields.io/badge/Dart-3.7+-blue?logo=dart" alt="Dart"></a>
  <a href="LICENSE"><img src="https://img.shields.io/badge/License-MIT-yellow.svg" alt="License: MIT"></a>
  <a href="https://github.com/sheeroo/ruko/stargazers"><img src="https://img.shields.io/github/stars/sheeroo/ruko.svg" alt="GitHub stars"></a>
  <a href="https://github.com/sheeroo/ruko/issues"><img src="https://img.shields.io/github/issues/sheeroo/ruko.svg" alt="GitHub issues"></a>
</p>
</div>

*Transform the tedious task of cleaning your camera roll into an addictive, swipe-based experience*

[🎥 Demo](#demo) • [✨ Features](#features) • [📲 Download](#download) • [🚀 Getting Started](#getting-started) • [🤝 Contributing](#contributing)

---

## 🎯 What is Ruko?

Ruko helps you clean your camera roll. Inspired by the familiar swipe mechanics of dating apps, Ruko makes decluttering your camera roll surprisingly addictive. Swipe right to keep, swipe left to delete – it's that simple, yet oddly satisfying.

---

## ✨ Features {#features}

### 🎭 Multiple Cleanup Modes

| Mode | Description | Perfect For |
|------|-------------|-------------|
| **🎲 Shuffle** | Random photo order | Breaking decision paralysis |
| **📅 By Month** | Chronologically grouped | Cleaning up specific time periods |
| **📍 By Location** | Geographically clustered | Removing photos from unwanted places |
| **📱 Screenshots** | System screenshots only | Quick cleanup of temporary saves |

### 🎮 Intuitive Gestures

- **👈 Swipe Left**: Delete photo/video
- **👉 Swipe Right**: Keep photo/video  
- **🔍 Tap**: View full-screen with metadata

### 🎯 Smart Features

- **🔄 Undo Support**: Accidentally deleted? No problem!
- **🔗 Share**: Found a gem memory? easily share it with your friends

---

## 📱 Download {#download}

### App Stores
- 📱 **iOS**: [Download from App Store](https://apps.apple.com/us/app/ruko-swipe-clean/id6746877731)
- 🤖 **Android**: *(Coming Soon)*

---

## 🤖 Android Port Plan & Scope

### MVP parity for first Android release (required)
- Swipe left/right cleanup flow for photos and videos
- Category-based cleanup modes (albums, month, location, screenshots, videos, shuffle, oldest-first)
- Delete + undo flow
- Fullscreen asset preview
- Share actions (Instagram story + system share)
- Permission onboarding and routing (Splash → Permission Request → Home)

### Post-MVP / future releases
- Android-specific UX optimizations for very large libraries
- Additional deletion safety UX for non-deletable/managed assets
- Expanded device and OS matrix hardening

### iOS-coupled points already identified
- Native method channel `photo_utils` (`isDeletable`) currently implemented on iOS and now mirrored on Android
- iOS-only permission assumptions replaced in startup/onboarding flows with `photo_manager` permission checks
- Platform config alignment tracked in Android manifest/build setup

### Android validation checklist
- Verify album loading and pagination on medium and large libraries
- Verify swipe keep/delete behavior and undo consistency
- Verify category filters and video playback
- Verify denied/limited permission flows and recovery from app settings
- Run static analysis and Android build before release

### Android beta release checklist
- Finalize signing configuration for Android release builds
- Validate app versioning and release artifacts (APK/AAB)
- Review store metadata/assets and privacy policy consistency
- Enable post-release monitoring for runtime/platform errors

---

## 🎥 Demo {#demo}

<div align="center">

<img src="demo/demo.gif" alt="Shuffle Demo" style="height: 650px;">

</div>

## 🚀 Getting Started {#getting-started}

### Prerequisites

- **Flutter**: `>=3.32.0`
- **Dart**: `>=3.7.0`

### 🛠️ Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/sheeroo/ruko
   cd ruko
   ```

2. **Install dependencies**
   ```bash
   flutter pub get
   ```

3. **Set up platform-specific configurations**

   **iOS:**
   ```bash
   cd ios && pod install && cd ..
   ```

4. **Run the app**
   ```bash
   flutter run
   ```

### 🔧 Build for Release

```bash
# Android
flutter build apk --release
flutter build appbundle --release

# iOS
flutter build ios --release
```

## 🤝 Contributing {#contributing}

### 🎯 Areas We Need Help With

- 🌍 **Localization**: Help translate Ruko into your language
- 🎨 **UI/UX**: Improve the user experience and design
- 🧪 **Testing**: Write tests
- 📱 **Platform Features**: iOS/Android specific enhancements
- 🐛 **Bug Fixes**: Squash bugs and improve stability

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

```
MIT License

Copyright (c) 2025 Ruko Contributors

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
...
```

---


## 📊 Project Stats

<div align="center">

![GitHub repo size](https://img.shields.io/github/repo-size/sheeroo/ruko)
![GitHub commit activity](https://img.shields.io/github/commit-activity/m/sheeroo/ruko)
![GitHub last commit](https://img.shields.io/github/last-commit/sheeroo/ruko)
![GitHub contributors](https://img.shields.io/github/contributors/sheeroo/ruko)

</div>

---


<div align="center">

**made with with love while being sleep deprived<3**

*If Ruko helped you free up storage space, consider giving us a ⭐!*

[⬆ Back to top](#-ruko)

</div>