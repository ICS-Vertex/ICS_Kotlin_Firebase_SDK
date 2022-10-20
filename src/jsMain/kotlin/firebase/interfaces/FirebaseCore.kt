// Copyright 2022 ICS Vertex
package firebase.interfaces

import firebase.config.FirebaseConfig
import firebase.wrappers.FirebaseAppImpl

/**
 * Interface to communicate with the firebase core features
 * @author Mike Dirven
 */
interface FirebaseCore {
    /**
     * Initialize a new firebase app implementation
     * @param config FirebaseConfig.() -> Unit
     * @return FirebaseAppImpl
     */
    fun initializeApp(config: firebase.config.FirebaseConfig.() -> Unit): FirebaseAppImpl
        = firebase.wrappers.initializeApp(firebase.config.FirebaseConfig().apply(config))
}