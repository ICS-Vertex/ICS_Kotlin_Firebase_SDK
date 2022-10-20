// Copyright 2022 ICS Vertex
package firebase.wrappers.database.classes.core

external class Query {
    val _orderByCalled: Boolean
    val _path: Path
    val _queryParams: QueryParams
    val _repo: RepoInternal
}

external class Path {
    val pieceNum: Int
    val pieces: List<String>
}

external class QueryParams {
    val endBeforeSet_ : Boolean
    val endNameSet_ : Boolean
    val endSet_ : Boolean
    val indexEndName_ : String
    val indexEndValue_ : Any
    val indexStartName_ : String
    val indexStartValue_ : Any
    val index_ : Any
    val limitSet_ : Boolean
    val limit_ : Int
    val startAfterSet_ : Boolean
    val startNameSet_ : Boolean
    val startSet_ : Boolean
    val viewForm : Int
}