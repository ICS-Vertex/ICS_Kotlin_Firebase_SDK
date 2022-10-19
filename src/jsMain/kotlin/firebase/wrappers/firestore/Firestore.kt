@file:JsModule("firebase/firestore")
@file:JsNonModule

package firebase.wrappers.firestore

import firebase.wrappers.FirebaseAppImpl
import firebase.wrappers.firestore.classes.collection.FirestoreCollectionReference
import firebase.wrappers.firestore.classes.core.FirestoreDatabase
import firebase.wrappers.firestore.classes.core.Query
import firebase.wrappers.firestore.classes.core.QueryOption
import firebase.wrappers.firestore.classes.doc.FirestoreDoc
import firebase.wrappers.firestore.classes.doc.FirestoreDocReference
import firebase.wrappers.firestore.classes.doc.FirestoreDocSnapshot
import firebase.wrappers.firestore.classes.doc.FieldPath
import firebase.wrappers.firestore.classes.fields.FieldValue
import kotlin.js.Promise

external fun getFirestore(app: FirebaseAppImpl): FirestoreDatabase
external fun getFirestore(): FirestoreDatabase

external fun terminate(fireStore: FirestoreDatabase) : Promise<*>

//Begin General
external fun where(field: String, operator: String, value: Any) : QueryOption
external fun where(field: FieldPath, operator: String, value: Any) : QueryOption
external fun limit(amount: Int) : QueryOption
external fun orderBy(field: String) : QueryOption
external fun startAt(document: FirestoreDocReference) : QueryOption
external fun startAt(index: Int) : QueryOption
external fun startAfter(document: FirestoreDocReference) : QueryOption
external fun startAfter(index: Int) : QueryOption
external fun endAt(document: FirestoreDocReference) : QueryOption
external fun endAt(index: Int) : QueryOption

external fun deleteField() : FieldValue
external fun increment(amount: Int) : FieldValue
external fun serverTimestamp() : FieldValue
external fun arrayRemove(vararg elements: Any) : FieldValue
external fun arrayUnion(vararg elements: Any) : FieldValue
external fun documentId() : FieldPath

external fun query(reference: FirestoreCollectionReference, vararg queries: QueryOption) : Query
//End General

//Begin Documents
external fun doc(db: FirestoreDatabase, vararg paths: String): FirestoreDocReference
external fun doc(reference: Any, path: String): FirestoreDocReference

external fun <T> setDoc(reference: FirestoreDocReference, data: T) : Promise<Any>
external fun <T> updateDoc(reference: FirestoreDocReference, data: T) : Promise<Any>
external fun deleteDoc(reference: FirestoreDocReference) : Promise<Any>

external fun getDoc(reference: FirestoreDocReference) : Promise<FirestoreDoc>
external fun getDocs(query: Query) : Promise<FirestoreDocSnapshot>
external fun getDocs(reference: FirestoreCollectionReference) : Promise<FirestoreDocSnapshot>
//End Documents

//Collections
external fun collection(db: FirestoreDatabase, vararg paths: String): FirestoreCollectionReference
external fun collection(reference: Any, path: String): FirestoreCollectionReference
//End Collection

//Begin Listeners
external fun onSnapshot(reference: FirestoreDocReference, callBack: Function<Unit>) : () -> Unit
external fun onSnapshot(reference: FirestoreCollectionReference, callBack: Function<Unit>) : () -> Unit
external fun onSnapshot(query: Query, callBack: Function<Unit>) : () -> Unit
//End Listeners