// Copyright 2022 ICS Vertex
package firebase

import firebase.interfaces.*

/**
 * Interface to expose all firebase api interfaces
 * @author Mike Dirven
 */
interface Firebase  {
    interface Core {
        companion object : FirebaseCore
    }
    interface Store {
        companion object : Firestore
    }
    interface Auth {
        companion object : Authentication
    }
    interface Database {
        companion object : RealTimeDatabase
    }
    interface Storage {
        companion object : FireStorage
    }
}