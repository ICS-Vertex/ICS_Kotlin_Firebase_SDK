// Copyright 2022 ICS Vertex
package firebase.wrappers.firestore.enums

enum class WhereOperator(val string: String) {
    EQUAL("=="),
    GREATER_THEN(">"),
    LESS_THEN("<"),
    GREATER_THE_OR_EQUAL(">="),
    LES_THEN_OR_EQUAL("<="),
}