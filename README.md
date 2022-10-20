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
