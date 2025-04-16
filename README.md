## 🏋️ TrackFit – Gym & Nutrition Tracker

**TrackFit** is a modern Android app built to help users manage their workout routines, track their diet, and monitor body progress over time. Designed with clean architecture principles, this project also serves as a **technical showcase** for Android development best practices.

---

### 📱 Features

- Register daily workouts and meals
- Visualize monthly progress through weight, body fat %, and comparison photos
- Reuse predefined training and diet plans
- Local storage with Room database
- Reminders and background tasks via WorkManager
- Secure data handling with encrypted preferences

---

### 🧠 Architecture & Tech Stack

- **Architecture**: MVVM + Clean Architecture (Domain, Data, and UI layers)
- **UI**: Jetpack Compose
- **State Management**: ViewModel + LiveData / StateFlow
- **Database**: Room
- **Background Work**: WorkManager
- **Dependency Injection**: Hilt
- **Navigation**: Jetpack Navigation Component
- **Asynchronous Programming**: Kotlin Coroutines & Flow
