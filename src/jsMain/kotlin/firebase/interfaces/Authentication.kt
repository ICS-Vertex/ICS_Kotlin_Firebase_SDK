// Copyright 2022 ICS Vertex
package firebase.interfaces

import firebase.wrappers.FirebaseAppImpl
import firebase.wrappers.authentication.classes.core.AuthImpl
import firebase.wrappers.authentication.classes.core.AuthProvider
import firebase.wrappers.authentication.classes.user.UserCredentialImpl
import firebase.wrappers.authentication.classes.user.UserImpl
import firebase.wrappers.authentication.classes.user.UserProfile
import kotlinx.js.jso
import kotlin.js.Promise

/**
 * Interface to communicate with the firebase authentication api
 * @author Mike Dirven
 */
interface Authentication {
    /**
     * Initialize firebase authentication from global firebase implementation
     * @return AuthImpl
     */
    fun getAuth() : AuthImpl = firebase.wrappers.authentication.getAuth()

    /**
     * Initialize firebase authentication from specified firebase implementation
     * @return AuthImpl
     */
    fun getAuth(app: FirebaseAppImpl) : AuthImpl = firebase.wrappers.authentication.getAuth(app)

    /**
     * Initialize firebase authentication from receiver firebase implementation
     * @return AuthImpl
     */
    fun FirebaseAppImpl.getAuth() : AuthImpl = firebase.wrappers.authentication.getAuth(this)

    //Create user
    /**
     * Create a user with email and password for the specified authentication implementation
     * @param authImpl AuthImpl
     * @param email String
     * @param password String
     * @return Promise<UserCredentialImpl>
     */
    fun createUser(authImpl: AuthImpl, email: String, password: String) : Promise<UserCredentialImpl>
        = firebase.wrappers.authentication.createUserWithEmailAndPassword(authImpl, email, password)

    /**
     * Create a user with email and password for the authentication implementation from receiver
     * @receiver AuthImpl
     * @param email String
     * @param password String
     * @return Promise<UserCredentialImpl>
     */
    fun AuthImpl.createUser(email: String, password: String) : Promise<UserCredentialImpl>
        = firebase.wrappers.authentication.createUserWithEmailAndPassword(this, email, password)

    //Account options
    /**
     * Send password reset email from the authentication implementation of the receiver
     * @receiver AuthImpl
     * @param email String
     * @return Promise<*>
     */
    fun AuthImpl.sendPasswordResetEmail(email: String) : Promise<*>
        = firebase.wrappers.authentication.sendPasswordResetEmail(this, email)

    /**
     * Send password reset email from the specified authentication implementation
     * @param auth AuthImpl
     * @param email String
     * @return Promise<*>
     */
    fun sendPasswordResetEmail(auth: AuthImpl, email: String) : Promise<*>
        = firebase.wrappers.authentication.sendPasswordResetEmail(auth, email)

    /**
     * Get all possible sign in options of the user from authentication implementation of the receiver
     * @receiver AuthImpl
     * @param email String
     * @return Promise<Array<String>>
     */
    fun AuthImpl.fetchSignInMethodsForEmail(email: String) : Promise<Array<String>>
        = firebase.wrappers.authentication.fetchSignInMethodsForEmail(this, email)

    /**
     * Get all possible sign in options of the user from specified authentication implementation
     * @param auth AuthImpl
     * @param email String
     * @return Promise<Array<String>>
     */
    fun fetchSignInMethodsForEmail(auth: AuthImpl, email: String) : Promise<Array<String>>
        = firebase.wrappers.authentication.fetchSignInMethodsForEmail(auth, email)

    /**
     * Sign out current user from authentication implementation of the receiver
     * @receiver AuthImpl
     * @return Promise<*>
     */
    fun AuthImpl.signOut() : Promise<*> = firebase.wrappers.authentication.signOut(this)

    /**
     * Sign out current user from specified authentication implementation
     * @param auth AuthImpl
     * @return Promise<*>
     */
    fun signOut(auth: AuthImpl) : Promise<*> = firebase.wrappers.authentication.signOut(auth)

    /**
     * Delete user account and sign out from authentication implementation of the receiver
     * @receiver UserImpl
     * @return Promise<*>
     */
    fun UserImpl.deleteUser() : Promise<*> = firebase.wrappers.authentication.deleteUser(this)

    /**
     * Delete user account and sign out from specified authentication implementation
     * @param user UserImpl
     * @return Promise<*>
     */
    fun deleteUser(user: UserImpl) : Promise<*> = firebase.wrappers.authentication.deleteUser(user)

    //Update user
    /**
     * Update user profile
     * @param user UserImpl
     * @param profile UserProfile.() -> Unit
     * @return Promise<*>
     */
    fun updateProfile(user: UserImpl, profile: UserProfile.() -> Unit) : Promise<*>
        = firebase.wrappers.authentication.updateProfile(user, jso<UserProfile>().apply(profile))

    /**
     * Update user profile
     * @receiver UserImpl
     * @param profile profile UserProfile.() -> Unit
     * @return Promise<*>
     */
    fun UserImpl.updateProfile(profile: UserProfile.() -> Unit) : Promise<*>
        = firebase.wrappers.authentication.updateProfile(this, jso<UserProfile>().apply(profile))

    /**
     * Update user email
     * @param user UserImpl
     * @param email String
     * @return Promise<*>
     */
    fun updateEmail(user: UserImpl, email: String) : Promise<*>
        = firebase.wrappers.authentication.updateEmail(user, email)

    /**
     * Update user email
     * @receiver UserImpl
     * @param email String
     * @return Promise<*>
     */
    fun UserImpl.updateEmail(email: String) : Promise<*>
        = firebase.wrappers.authentication.updateEmail(this, email)

    /**
     * Update user password
     * @param user UserImpl
     * @param password String
     * @return Promise<*>
     */
    fun updatePassword(user: UserImpl, password: String) : Promise<*>
        = firebase.wrappers.authentication.updatePassword(user, password)

    /**
     * Update user password
     * @receiver UserImpl
     * @param password String
     * @return Promise<*>
     */
    fun UserImpl.updatePassword(password: String) : Promise<*>
        = firebase.wrappers.authentication.updatePassword(this, password)

    //Sign in
    /**
     * Sign in user with email and password to specified authentication implementation
     * @param authImpl AuthImpl
     * @param email String
     * @param password String
     * @return Promise<UserCredentialImpl>
     */
    fun signIn(authImpl: AuthImpl, email: String, password: String) : Promise<UserCredentialImpl>
        = firebase.wrappers.authentication.signInWithEmailAndPassword(authImpl, email, password)

    /**
     * Sign in user with email and password to authentication implementation from receiver
     * @receiver AuthImpl
     * @param email String
     * @param password String
     * @return Promise<UserCredentialImpl>
     */
    fun AuthImpl.signIn(email: String, password: String) : Promise<UserCredentialImpl>
        = firebase.wrappers.authentication.signInWithEmailAndPassword(this, email, password)

    /**
     * Sign in with pop up from specified auth provider to specified authentication implementation
     * @param auth AuthImpl
     * @param provider AuthProvider
     * @return Promise<UserCredentialImpl>
     */
    fun signInWithPopup(auth: AuthImpl, provider: AuthProvider) : Promise<UserCredentialImpl>
        = firebase.wrappers.authentication.signInWithPopup(auth, provider)

    /**
     * Sign in with pop up from specified auth provider to authentication implementation from receiver
     * @receiver AuthImpl
     * @param provider AuthProvider
     * @return Promise<UserCredentialImpl>
     */
    fun AuthImpl.signInWithPopup(provider: AuthProvider) : Promise<UserCredentialImpl>
        = firebase.wrappers.authentication.signInWithPopup(this, provider)

    //Listener
    /**
     * Setup auth state change listener
     * Callback will be called everytime the auth has been changed
     * @param authImpl AuthImpl
     * @param callBack UserCredentialImpl.() -> Unit
     * @return Any
     */
    fun onAuthStateChanged(authImpl: AuthImpl, callBack: UserCredentialImpl.() -> Unit) : Any
        = firebase.wrappers.authentication.onAuthStateChanged(authImpl, callBack)

    /**
     * Setup auth state change listener
     * Callback will be called everytime the auth has been changed
     * @receiver AuthImpl
     * @param callBack UserCredentialImpl.() -> Unit
     * @return Any
     */
    fun AuthImpl.onAuthStateChanged(callBack: UserCredentialImpl.() -> Unit) : Any
        = firebase.wrappers.authentication.onAuthStateChanged(this, callBack)

    /**
     * Setup auth state before change listener
     * Callback will be called everytime before the auth has been changed
     * @param authImpl AuthImpl
     * @param callBack UserCredentialImpl.() -> Unit
     * @return Any
     */
    fun beforeAuthStateChanged(authImpl: AuthImpl, callBack: UserCredentialImpl.() -> Unit) : Any
        = firebase.wrappers.authentication.beforeAuthStateChanged(authImpl, callBack)

    /**
     * Setup auth state before change listener
     * Callback will be called everytime before the auth has been changed
     * @receiver AuthImpl
     * @param callBack UserCredentialImpl.() -> Unit
     * @return Any
     */
    fun AuthImpl.beforeAuthStateChanged(callBack: UserCredentialImpl.() -> Unit) : Any
        = firebase.wrappers.authentication.beforeAuthStateChanged(this, callBack)
}