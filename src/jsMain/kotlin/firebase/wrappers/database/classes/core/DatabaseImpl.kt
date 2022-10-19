package firebase.wrappers.database.classes.core

import firebase.wrappers.firestore.classes.core.FirestoreApp

external class DatabaseImpl {
    val _instanceStarted: Boolean
    val _repoInternal: RepoInternal
    val app: FirestoreApp
    val type: String
}

external class RepoInternal {
    val appCheckProvider_: AppCheckProvider
    val authTokenProvider_: AuthTokenProvider
    val dataUpdateCount: Int
    val eventQueue_: EventQueue
    val forceRestClient_: Boolean
    val interceptServerDataCallback_: Any?
    val key: String
    val nextWriteId_: Int
    val onDisconnect_: OnDisconnect
    val persistentConnection_: Any?
    val repoInfo_: RepoInfo
    val statsListener_: Any?
    val transactionQueueTree_: TransactionQueueTree
}

external class AppCheckProvider {
    val appCheck: Any?
    val appCheckProvider: AppCheckProviderInternal
    val appName_: String
}

external class AppCheckProviderInternal {
    val component: Any?
    val container: Container
    val instances: Any
    val instancesDeferred: Any
    val instancesOptions: Any
    val name: String
    val onInitCallbacks: Any
}

external class Container {
    val name: String
    val providers: Any
}

external class AuthTokenProvider {
    val appName_: String
    val authProvider_: AuthProvider
    val auth_: Auth
    val firebaseOptions_: FirebaseOptions
}

external class AuthProvider {
    val component: Component
    val container: Container
    val instances: Any
    val instancesDeferred: Any
    val instancesOptions: Any
    val name: String
    val onInitCallbacks: Any
}

external class Component {
    val instantiationMode: String
    val multipleInstances: Boolean
    val name: String
    val onInstanceCreated: Any?
    val serviceProps: Any
    val type: String
}

external class Auth {
    val auth: AuthInternal
    val internalListeners: Any
}

external class AuthInternal {
    val apiKey: String
    val appName: String
    val authDomain: String
    val currentUser: CurrentUser
}

external class CurrentUser {
    val apiKey: String
    val appName: String
    val createdAt: String
    val displayName: String
    val email: String
    val emailVerified: Boolean
    val isAnonymous: Boolean
    val lastLoginAt: String
    val photoURL: String
    val providerData: List<ProviderData>
    val stsTokenManager: StsTokenManager
    val uid: String
}

external class ProviderData{
    val displayName: String
    val email: String
    val phoneNumber: Any?
    val photoURL: String
    val providerId: String
    val uid: String
}

external class StsTokenManager{
    val accessToken: String
    val expirationTime: Long
    val refreshToken: String
}

external class FirebaseOptions{
    val apiKey: String
    val appId: String
    val authDomain: String
    val databaseURL: String
    val messagingSenderId: String
    val projectId: String
    val storageBucket: String
}

external class EventQueue{
    val eventLists_: List<Any>
    val recursionDepth_: Int
}

external class OnDisconnect{
    val children: Any
    val value: Any?
}

external class RepoInfo{
    val _domain: String
    val _host: String
    val includeNamespaceInQueryParams: Boolean
    val internalHost: String
    val namespace: String
    val nodeAdmin: Boolean
    val persistenceKey: String
    val secure: Boolean
    val webSocketOnly: Boolean
}

external class TransactionQueueTree{
    val name: String
    val node: Node
    val parent: Any?
}

external class Node{
    val childCount: Int
    val children: Any
}