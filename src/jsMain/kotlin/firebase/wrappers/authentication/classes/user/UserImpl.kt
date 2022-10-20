// Copyright 2022 ICS Vertex
package firebase.wrappers.authentication.classes.user

external class UserImpl {
    val apiKey: String
    val appName: String
    val createdAt: String
    val email: String
    val emailVerified: Boolean
    val isAnonymous: Boolean
    val lastLoginAt: String
    val providerData: List<ProviderData>
    val stsTokenManager: StsTokenManager
    val uid: String
}

external class ProviderData {
    val displayName: Any?
    val email: String
    val phoneNumber: Any?
    val photoURL: Any?
    val providerId: String
    val uid: String
}

external class StsTokenManager {
    val accessToken: String
    val expirationTime: Long
    val refreshToken: String
}