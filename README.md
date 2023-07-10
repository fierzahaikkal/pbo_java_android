# PBO Java Android
Repository tugas kelompok mata kuliah pemrograman berbasis objek materi android

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Contributing](#contributing)
- [License](#license)

## Getting Started

These instructions will help you set up the project on your local machine for development and collaboration.

### Prerequisites

- [Android Studio](https://developer.android.com/studio): Download and install Android Studio on your machine.
- [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git): Install Git if it's not already installed.
- GitHub Account: Create a GitHub account if you don't have one.

### Requirements

- Android SDK version: 16 (minSdkVersion)
- Target SDK version: 33 (targetSdkVersion)

### Depedencies
```gradle
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.9.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'com.google.android.gms:play-services-location:21.0.1'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test:runner:1.5.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'

    //
    implementation 'com.synnapps:carouselview:0.1.4'
    implementation 'com.karumi:dexter:6.2.3'
    implementation 'com.airbnb.android:lottie:6.0.1'

    //OkHttp
    implementation 'com.squareup.okhttp3:okhttp:4.11.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:4.11.0'
```

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/fierzahaikkal/pbo_java_android.git
    ```
2. Open Android Studio.
3. Click on "Open an existing Android Studio project" and select the cloned repository.
4. Wait for the project to sync and build.

## Contributing

To contribute to the project, please follow the steps below:

1. Open up your terminal and cd to your local repo
2. Checkout to develop branch on your local machine
    ```bash
    git checkout develop
    ```
3. Check the latest repository updates
    ```bash
    git status
    ```
4. Pull all recent changes
   ```bash
   git pull
   ```
5. Create a new branch for your feature or bug fix:
    ```bash
    git checkout -b feature/your-feature-name
    ```
    or
    ```bash
    gcb feature/your-feature-name
    ```
6. Make your changes and test thoroughly.
7. Check to see what changes have occurred
   ```bash
   git status
   ```
8. Change files into staged state
   ```bash
   git add .
   ```
9. Commit your changes:
    ```bash
    git commit -m "feature: add your message"
    ```
10. Fetch all the changes to keep your local repository updated
    ```bash
    git fetch
    ```
11. Push the branch to your forked repository:
    ```bash
    git push -u origin feature/your-feature-name
    ```
12. Open a pull request on the main repository. Be sure to provide a clear and descriptive title, as well as a detailed description of the changes you've made.

## License

© This project is a college assignment and is provided for educational purposes only. The code and assets are not licensed for general use, modification, or distribution.

---
