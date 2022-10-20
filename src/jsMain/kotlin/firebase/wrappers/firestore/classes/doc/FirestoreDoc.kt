// Copyright 2022 ICS Vertex
package firebase.wrappers.firestore.classes.doc

import firebase.wrappers.FirebaseAppImpl
import firebase.wrappers.firestore.classes.core.DatabaseId
import kotlin.js.Json

external class FirestoreDoc{
    val _converter: Any?
    val _document: Document
    val _firestore: Firestore
    val _firestoreImpl: FirestoreImpl
    val _key: Key
    val _userDataWriter: UserDataWriter
    val metadata: Metadata

    fun exists() : Boolean
    fun data() : Json
    fun <T> data() : T
}

//General
external class Key {
    val path: Path
}

external class Path {
    val len: Int
    val offset: Int
    val segments: List<String>
}

//Begin document
external class Document {
    val `data`: Data
    val documentState: Int
    val documentType: Int
    val key: Key
    val readTime: ReadTime
    val version: Version
}

external class Data{
    val value: Value
}

external class Value {
    val mapValue: MapValue
}

external class MapValue {
    val fields: Any
}

external class ReadTime {
    val timestamp: Timestamp
}

external class Timestamp {
    val nanoseconds: Int
    val seconds: Int
}

external class Version {
    val timestamp: Timestamp
}
//End document

//Begin firestore
external class Firestore {
    val app: FirebaseAppImpl
    val databaseId: DatabaseId
    val settings: Settings
}

external class Settings{
    val cacheSizeBytes: Int
    val experimentalAutoDetectLongPolling: Boolean
    val experimentalForceLongPolling: Boolean
    val host: String
    val ignoreUndefinedProperties: Boolean
    val ssl: Boolean
    val useFetchStreams: Boolean
}
//End firestore

//Begin firestoreImpl
external class FirestoreImpl{
    val app: FirebaseAppImpl
    val databaseId: DatabaseId
    val settings: Settings
}
//end firestoreimpl

//Begin user data writer
external class UserDataWriter{
    val firestore: Firestore
}
//End user data writer

//Begin meta data
external class Metadata{
    val fromCache: Boolean
    val hasPendingWrites: Boolean
}
//End meta data