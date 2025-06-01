## 🏋️ TrackFit – Gym & Nutrition Tracker

**TrackFit** is a modern Android app designed to help users manage workout routines, monitor nutrition, and track physical progress. Built with **Clean Architecture** principles, it also serves as a **technical showcase** for Android development best practices.

> 🚧 **Project status**: TrackFit is currently under active development. The **Body Stats** feature — which allows users to track weight, body fat percentage, and compare progress photos over time — is the core of the MVP and is being prioritized. Additional features such as workout and meal tracking will be added in future iterations.

---

### 📱 Current Feature

- 📊 **Body Stats Tracking**:
    - Log body weight, body fat %, and visceral fat
    - Attach progress photos
    - Visualize historical data

---

### 🚀 Planned Features

- 💪 Workout logging and training plan reuse
- 🍽️ Meal tracking and diet templates
- ⏰ Reminders with WorkManager
- 🔐 Secure data storage using encrypted preferences

---

### 🧠 Architecture & Tech Stack

- **Architecture**: MVVM + Clean Architecture (UI, Domain, and Data layers)
- **UI Toolkit**: Jetpack Compose
- **State Management**: ViewModel + StateFlow / LiveData
- **Persistence**: Room
- **Background Tasks**: WorkManager
- **Dependency Injection**: Hilt
- **Navigation**: Jetpack Navigation Component
- **Concurrency**: Kotlin Coroutines & Flow