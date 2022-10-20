// Copyright 2022 ICS Vertex
package firebase.wrappers.firestore.classes.core

import firebase.wrappers.firestore.classes.doc.Firestore

external class Query{
    val _query: InternalQuery
    val converter: Any?
    val firestore: Firestore
    val type: String
}

//Begin internal query
external class InternalQuery {
    val _t: Any?
    val collectionGroup: Any?
    val endAt: Any?
    val explicitOrderBy: List<ExplicitOrderBy>
    val filters: List<Filter>
    val limit: Int
    val limitType: String
    val path: Path
    val startAt: Any?
    val wt: Any?
}

external class ExplicitOrderBy {
    val dir: String
    val `field`: Field
}

external class Field {
    val len: Int
    val offset: Int
    val segments: List<String>
}

external class Filter {
    val `field`: Field
    val op: String
    val value: Value
}

external class Value {
    val stringValue: String
}

external class Path {
    val len: Int
    val offset: Int
    val segments: List<String>
}
//End internal query