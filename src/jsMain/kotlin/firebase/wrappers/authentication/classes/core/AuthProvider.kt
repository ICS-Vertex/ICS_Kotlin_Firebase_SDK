// Copyright 2022 ICS Vertex
package firebase.wrappers.authentication.classes.core

import firebase.wrappers.authentication.classes.user.UserCredentialImpl

open external class AuthProvider {
    fun credentialFromResult(result: UserCredentialImpl): Any
}