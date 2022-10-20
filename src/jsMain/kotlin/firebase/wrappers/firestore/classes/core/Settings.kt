// Copyright 2022 ICS Vertex
package firebase.wrappers.firestore.classes.core

external class Settings {
    val cacheSizeBytes: Int
    val experimentalAutoDetectLongPolling: Boolean
    val experimentalForceLongPolling: Boolean
    val host: String
    val ignoreUndefinedProperties: Boolean
    val ssl: Boolean
    val useFetchStreams: Boolean
}