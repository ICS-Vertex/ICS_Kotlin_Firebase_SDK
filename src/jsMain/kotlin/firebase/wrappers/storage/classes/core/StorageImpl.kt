package firebase.wrappers.storage.classes.core

import firebase.wrappers.FirebaseAppImpl
import firebase.wrappers.database.classes.core.AppCheckProviderInternal
import firebase.wrappers.database.classes.core.AuthProvider

external class StorageImpl {
    val app : FirebaseAppImpl
    val _appCheckProvider: AppCheckProviderInternal
    val _authProvider: AuthProvider
    val _bucket: Bucket
    val _deleted: Boolean
    val _firebaseVersion: String
    val _host: String
    val _maxOperationRetrytime: Long
    val _maxUploadRetryTime: Long
    val _protocol: String
    val _requests: Set<Any>
    val _url: Any
}

external class Bucket {
    val bucket: String
    val path: String
}