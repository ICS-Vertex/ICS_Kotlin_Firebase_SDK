[![Kotlin-js](https://img.shields.io/badge/Kotlin--js-V1.7.10-%23039BE5.svg?style=for-the-badge&logo=kotlin)](https://kotlinlang.org/docs/whatsnew17.html)
[![Firebase](https://img.shields.io/badge/firebase-V9.12.1-%23039BE5.svg?style=for-the-badge&logo=firebase)](https://firebase.google.com/support/release-notes/js)
[![License](https://img.shields.io/badge/License-Apache--2.0-%23039BE5.svg?style=for-the-badge&logo=license)](https://github.com/ICS-Vertex/ICS_Kotlin_Firebase_SDK/blob/master/License.md)

Available products from firebase
* Authentication
* Realtime database
* Firestore
* Storage

## Implement the package
```gradle
repositories {
    maven("https://maven.pkg.github.com/ICS-Vertex/ICS_Kotlin_Firebase_SDK"){
        credentials {
            username = GitHub_Username
            password = GitHub_Token
        }
    }
}

dependencies {
    implementation("nl.ics:kotlin_firebase_sdk-js:1.0.0-alpha")
}
```

## Initialize Firebase
To initialize fire for your project call the initializeApp function to setup youre firebase implementation

```kotlin
Firebase.initializeApp {
        apiKey = ""
        authDomain = ""
        databaseURL = ""
        projectId = ""
        storageBucket = ""
        messagingSenderId = ""
        appId = ""
    }
```

## Initialize Firebase components
```kotlin
val authentication = Firebase.getAuth()
val database= Firebase.getDatabase()
val fireStore = Firebase.getFirestore()
val storage= Firebase.getStorage()
```
