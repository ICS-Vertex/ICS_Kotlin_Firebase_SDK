// Copyright 2022 ICS Vertex
package firebase.wrappers.firestore.classes.doc

external class FieldPath {
    val _internalPath: InternalPath
}

external class InternalPath {
    val len : Int
    val offset : Int
    val segments : Array<String>
}