// Copyright 2022 ICS Vertex
@file:JsModule("firebase/app")
@file:JsNonModule

package firebase.wrappers

import firebase.config.FirebaseConfig
import firebase.config.classes.FirebaseClient
import firebase.config.classes.FirebaseProjectInfo

external val initializeApp: (config: FirebaseConfig) -> FirebaseAppImpl = definedExternally

external class FirebaseAppImpl {
    val _isDeleted: Boolean
    val options: FireBaseAppImplOptions
    val _config: FirebaseAppImplConfig
    val name: String
    val _automaticDataCollectionEnabled: Boolean
    val _container: Container
    fun checkDestroyed()
}

external class FireBaseAppImplOptions {
    val client: Array<FirebaseClient>
    val configuration_version: Int
    val project_info: FirebaseProjectInfo
}

external class FirebaseAppImplConfig {
    val automaticDataCollectionEnabled: Boolean
    val name: String
}

external class Container {
    val name: String
    val providers: Map<String, *>
}