// Copyright 2022 ICS Vertex
package firebase.wrappers.storage.classes.core

external class StorageReference {
    val _location: Location
    val _service: StorageImpl
    val name: String
    val fullPath: String
    val bucket: String
    val parent: StorageReference
    val root: StorageReference
}

external class Location {
    val bucket: String
    val path: String
}