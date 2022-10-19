@file:JsModule("firebase/auth")
@file:JsNonModule


package firebase.wrappers.authentication

import firebase.wrappers.FirebaseAppImpl
import firebase.wrappers.authentication.classes.core.AuthImpl
import firebase.wrappers.authentication.classes.core.AuthProvider
import firebase.wrappers.authentication.classes.user.UserCredentialImpl
import firebase.wrappers.authentication.classes.user.UserImpl
import firebase.wrappers.authentication.classes.user.UserProfile
import kotlin.js.Promise

external fun getAuth(app: FirebaseAppImpl) : AuthImpl
external fun getAuth() : AuthImpl

//Begin Creation options
external fun createUserWithEmailAndPassword(auth: AuthImpl, email: String, password: String) : Promise<UserCredentialImpl>
//End Creation options

//Begin SignIn options
external fun signInWithEmailAndPassword(auth: AuthImpl, email: String, password: String) : Promise<UserCredentialImpl>
external fun signInWithPopup(auth: AuthImpl, provider: AuthProvider) : Promise<UserCredentialImpl>
external fun fetchSignInMethodsForEmail(auth: AuthImpl, email: String) : Promise<Array<String>>
//End SignIn options

external fun onAuthStateChanged(authImpl: AuthImpl, callBack: Function<*>) : Any
external fun beforeAuthStateChanged(authImpl: AuthImpl, callBack: Function<*>) : Any
external fun sendPasswordResetEmail(auth: AuthImpl, email: String) : Promise<*>
external fun deleteUser(userImpl: UserImpl) : Promise<*>
external fun signOut(auth: AuthImpl) : Promise<*>

external fun updateProfile(user: UserImpl, profileUpdates: UserProfile) : Promise<*>
external fun updateEmail(user: UserImpl, email: String) : Promise<*>
external fun updatePassword(user: UserImpl, password: String) : Promise<*>

//Classes
external class GoogleAuthProvider : AuthProvider{
    companion object : AuthProvider
}