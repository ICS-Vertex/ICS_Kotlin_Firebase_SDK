package firebase.wrappers.authentication.classes.user

external class UserCredentialImpl {
    val _tokenResponse: TokenResponse
    val operationType: String
    val providerId: Any?
    val user: UserImpl
}

external class TokenResponse {
    val email: String
    val expiresIn: String
    val idToken: String
    val kind: String
    val localId: String
    val refreshToken: String
}