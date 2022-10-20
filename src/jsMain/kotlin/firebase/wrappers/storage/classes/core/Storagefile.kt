// Copyright 2022 ICS Vertex
package firebase.wrappers.storage.classes.core

external class StorageFile {
    val metaData: FileMetaData
    val ref: StorageReference
}

external class FileMetaData {
    val bucket: String
    val cacheControl: Any
    val contentDisposition: String
    val contentEncoding: String
    val contentLanguage: String
    val contentType: String
    val contentMetaData: Any
    val fullPath: String
    val generation: String
    val md5Hash: String
    val metageneration: String
    val name: String
    val size: Long
    val timeCreated: String
    val type: String
    val updated: String
}