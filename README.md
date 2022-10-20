Available products from firebase
* Authentication
* Realtime database
* Firestore
* Storage

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
