package firebase.wrappers.firestore.classes.doc

import kotlin.js.Json

external class FirestoreDocSnapshot {
    val _firestore: Firestore
    val _userDataWriter: UserDataWriter
    val metadata: Metadata
    val _Snapshot: SnapShot
    val docs: Array<FirestoreDoc>
    fun exists() : Boolean
    fun data() : Json
    fun <T> data() : T
}

fun FirestoreDocSnapshot.docs(forEach: (FirestoreDoc) -> Unit){
    this.docs.forEach {
        it.apply(forEach)
    }
}