package firebase.interfaces

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
import firebase.wrappers.firestore.enums.WhereOperator
import kotlinx.js.JsoDsl
import kotlinx.js.jso
import kotlin.js.Promise

/**
 * Interface to communicate with the firebase firestore api
 * @author Mike Dirven
 */
interface Firestore {
    /**
     * Initialize firebase firestore from global firebase implementation
     * @return FirestoreDatabase
     */
    fun getFirestore(): FirestoreDatabase = firebase.wrappers.firestore.getFirestore()

    /**
     * Initialize firebase firestore from specified firebase implementation
     * @param appConfig FirebaseAppImpl
     * @return FirestoreDatabase
     */
    fun getFirestore(app: FirebaseAppImpl): FirestoreDatabase = firebase.wrappers.firestore.getFirestore(app)

    /**
     * Initialize firebase firestore from firebase implementation of the receiver
     * @receiver FirebaseAppImpl
     * @return FirestoreDatabase
     */
    fun FirebaseAppImpl.getFirestore() : FirestoreDatabase = firebase.wrappers.firestore.getFirestore(this)

    /**
     * Terminates the firestore connection
     * @param storage StorageImpl
     * @return Promise<*>
     */
    fun terminate(storage: FirestoreDatabase) : Promise<*> = firebase.wrappers.firestore.terminate(storage)

    /**
     * Terminates the firestore connection
     * @receiver StorageImpl
     * @return Promise<*>
     */
    fun FirestoreDatabase.terminate() : Promise<*> = firebase.wrappers.firestore.terminate(this)

    //General
    /**
     * Create a where query option
     * @param field String
     * @param operator WhereOperator
     * @param value Any
     * @return QueryOption
     */
    fun where(field: String, operator: WhereOperator, value: Any) : QueryOption = firebase.wrappers.firestore.where(field, operator.string, value)

    /**
     * Create a where query option
     * @param field FieldPath
     * @param operator WhereOperator
     * @param value Any
     * @return QueryOption
     */
    fun where(field: FieldPath, operator: WhereOperator, value: Any) : QueryOption = firebase.wrappers.firestore.where(field, operator.string, value)

    /**
     * Create a limit query option
     * @param amount Int
     * @return QueryOption
     */
    fun limit(amount: Int) : QueryOption = firebase.wrappers.firestore.limit(amount)

    /**
     * Create a order by option
     * @param field String
     * @return QueryOption
     */
    fun orderBy(field: String) : QueryOption = firebase.wrappers.firestore.orderBy(field)

    /**
     * Create a start at option
     * @param document FirestoreDocReference
     * @return QueryOption
     */
    fun startAt(document: FirestoreDocReference) = firebase.wrappers.firestore.startAt(document)

    /**
     * Create a start at option
     * @param index Int
     * @return QueryOption
     */
    fun startAt(index: Int) = firebase.wrappers.firestore.startAfter(index)

    /**
     * Create a start after option
     * @param document FirestoreDocReference
     * @return QueryOption
     */
    fun startAfter(document: FirestoreDocReference) = firebase.wrappers.firestore.startAfter(document)

    /**
     * Create a start after option
     * @param index Int
     * @return QueryOption
     */
    fun startAfter(index: Int) = firebase.wrappers.firestore.startAfter(index)

    /**
     * Create a end at option
     * @param document FirestoreDocReference
     * @return QueryOption
     */
    fun endAt(document: FirestoreDocReference) = firebase.wrappers.firestore.endAt(document)

    /**
     * Create a end at option
     * @param index Int
     * @return QueryOption
     */
    fun endAt(index: Int) = firebase.wrappers.firestore.endAt(index)

    /**
     * Create a query to filter on a collection
     * @param reference FirestoreCollectionReference
     * @param queries Array<out QueryOption>
     * @return Query
     */
    fun query(reference: FirestoreCollectionReference, vararg queries: QueryOption) : Query = firebase.wrappers.firestore.query(reference, *queries)

    /**
     * Create a query to filter on a collection
     * @receiver FirestoreCollectionReference
     * @param queries Array<out QueryOption>
     * @return Query
     */
    fun FirestoreCollectionReference.query(vararg queries: QueryOption) : Query = firebase.wrappers.firestore.query(this, *queries)

    //Documents
    /**
     * Get document id for use in query options
     * @return FieldPath
     */
    fun documentId() : FieldPath = firebase.wrappers.firestore.documentId()

    /**
     * Get document from specified database
     * @param db FirestoreDatabase
     * @param paths Array<out String>
     * @return FirestoreDocReference
     */
    fun doc(db: FirestoreDatabase, vararg paths: String) : FirestoreDocReference = firebase.wrappers.firestore.doc(db, *paths)

    /**
     * Get document from collection reference from receiver
     * @receiver FirestoreCollectionReference
     * @param path String
     * @return FirestoreDocReference
     */
    fun FirestoreCollectionReference.doc(path: String) : FirestoreDocReference = firebase.wrappers.firestore.doc(this, path)

    /**
     * Set new document on specified reference with data from lambda
     * @param document FirestoreDocReference
     * @param data @JsoDsl T.() -> Unit
     * @return Promise<Any>
     */
    fun <T : Any> setDoc(document: FirestoreDocReference, data: @JsoDsl T.() -> Unit) : Promise<Any> = firebase.wrappers.firestore.setDoc(document, jso<T>().apply(data))

    /**
     * Set new document on specified reference with data from data object
     * @param document FirestoreDocReference
     * @param data T
     * @return Promise<Any>
     */
    fun <T : Any> setDoc(document: FirestoreDocReference, data: T) : Promise<Any> = firebase.wrappers.firestore.setDoc(document, data)

    /**
     * Set new document on reference from receiver with data from lambda
     * @receiver FirestoreDocReference
     * @param data @JsoDsl T.() -> Unit
     * @return Promise<Any>
     */
    fun <T : Any> FirestoreDocReference.setDoc(data: @JsoDsl T.() -> Unit) : Promise<Any> = firebase.wrappers.firestore.setDoc(this, jso<T>().apply(data))

    /**
     * Set new document on reference from receiver with data from data object
     * @receiver FirestoreDocReference
     * @param data T
     * @return Promise<Any>
     */
    fun <T : Any> FirestoreDocReference.setDoc(data: T) : Promise<Any> = firebase.wrappers.firestore.setDoc(this, data)

    /**
     * Update document on specified reference with data from lambda
     * @param document FirestoreDocReference
     * @param data @JsoDsl T.() -> Unit
     * @return Promise<Any>
     */
    fun <T : Any> updateDoc(document: FirestoreDocReference, data: @JsoDsl T.() -> Unit) : Promise<Any> = firebase.wrappers.firestore.updateDoc(document, jso<T>().apply(data))

    /**
     * Update document on reference from receiver with data from lambda
     * @receiver FirestoreDocReference
     * @param data [@kotlinx.js.JsoDsl] [@kotlin.ExtensionFunctionType] Function1<T, Unit>
     * @return Promise<Any>
     */
    fun <T : Any> FirestoreDocReference.updateDoc(data: @JsoDsl T.() -> Unit) : Promise<Any> = firebase.wrappers.firestore.updateDoc(this, jso<T>().apply(data))

    /**
     * Update document on specified reference with data from data object
     * @param document FirestoreDocReference
     * @param data T
     * @return Promise<Any>
     */
    fun <T : Any> updateDoc(document: FirestoreDocReference, data: T) : Promise<Any> = firebase.wrappers.firestore.updateDoc(document, data)

    /**
     * Update document on reference from receiver with data from data object
     * @receiver FirestoreDocReference
     * @param data T
     * @return Promise<Any>
     */
    fun <T : Any> FirestoreDocReference.updateDoc(data: T) : Promise<Any> = firebase.wrappers.firestore.updateDoc(this, data)

    /**
     * Delete document on specified reference
     * @param document FirestoreDocReference
     * @return Promise<Any>
     */
    fun deleteDoc(document: FirestoreDocReference) : Promise<Any> = firebase.wrappers.firestore.deleteDoc(document)

    /**
     * Delete document on reference from receiver
     * @receiver FirestoreDocReference
     * @return Promise<Any>
     */
    fun FirestoreDocReference.deleteDoc() : Promise<Any> = firebase.wrappers.firestore.deleteDoc(this)

    /**
     * Get document from specified reference
     * @param document FirestoreDocReference
     * @return Promise<FirestoreDoc>
     */
    fun getDoc(document: FirestoreDocReference) : Promise<FirestoreDoc> = firebase.wrappers.firestore.getDoc(document)

    /**
     * Get document of reference from receiver
     * @receiver FirestoreDocReference
     * @return Promise<FirestoreDoc>
     */
    fun FirestoreDocReference.getDoc() : Promise<FirestoreDoc> = firebase.wrappers.firestore.getDoc(this)

    /**
     * Get documents from specified query
     * @param query Query
     * @return Promise<FirestoreDocSnapshot>
     */
    fun getDocs(query: Query) : Promise<FirestoreDocSnapshot> = firebase.wrappers.firestore.getDocs(query)

    /**
     * Get document from query
     * @receiver Query
     * @return Promise<FirestoreDocSnapshot>
     */
    fun Query.getDocs() : Promise<FirestoreDocSnapshot> = firebase.wrappers.firestore.getDocs(this)

    /**
     * Get document from specified collection reference
     * @param reference FirestoreCollectionReference
     * @return Promise<FirestoreDocSnapshot>
     */
    fun getDocs(reference: FirestoreCollectionReference) : Promise<FirestoreDocSnapshot> = firebase.wrappers.firestore.getDocs(reference)

    /**
     * Get document on collection reference from receiver
     * @receiver FirestoreCollectionReference
     * @return Promise<FirestoreDocSnapshot>
     */
    fun FirestoreCollectionReference.getDocs() : Promise<FirestoreDocSnapshot> = firebase.wrappers.firestore.getDocs(this)

    //Collections
    /**
     * Get collection reference from specified database and paths
     * @param db FirestoreDatabase
     * @param paths Array<out String>
     * @return FirestoreCollectionReference
     */
    fun collection(db: FirestoreDatabase, vararg paths: String) : FirestoreCollectionReference = firebase.wrappers.firestore.collection(db, *paths)

    /**
     * Get collection reference from path on database from receiver
     * @receiver FirestoreDatabase
     * @param path String
     * @return FirestoreCollectionReference
     */
    fun FirestoreDatabase.collection(path: String) : FirestoreCollectionReference = firebase.wrappers.firestore.collection(this, path)

    /**
     * Get collection reference from path on reference from receiver
     * @receiver FirestoreDocReference
     * @param path String
     * @return FirestoreCollectionReference
     */
    fun FirestoreDocReference.collection(path: String) : FirestoreCollectionReference = firebase.wrappers.firestore.collection(this, path)

    //Listeners
    /**
     * Set up a snapshot listener that triggers every time there is a change on the specified reference
     * @param reference FirestoreDocReference
     * @param callBack FirestoreDoc.() -> Unit
     * @return () -> Unit = Unsubscribe function
     */
    fun onSnapshot(reference: FirestoreDocReference, callBack: FirestoreDoc.() -> Unit) : () -> Unit = firebase.wrappers.firestore.onSnapshot(reference, callBack)

    /**
     * Set up a snapshot listener that triggers every time there is a change on the reference from receiver
     * @receiver FirestoreDocReference
     * @param callBack FirestoreDoc.() -> Unit
     * @return () -> Unit = Unsubscribe function
     */
    fun FirestoreDocReference.onSnapshot(callBack: FirestoreDoc.() -> Unit) : () -> Unit = firebase.wrappers.firestore.onSnapshot(this, callBack)

    /**
     * Set up a snapshot listener that triggers every time there is a change on the specified reference
     * @param reference FirestoreCollectionReference
     * @param callBack Promise<FirestoreDocSnapshot>.() -> Unit
     * @return () -> Unit = Unsubscribe function
     */
    fun onSnapshot(reference: FirestoreCollectionReference, callBack: Promise<FirestoreDocSnapshot>.() -> Unit) : () -> Unit = firebase.wrappers.firestore.onSnapshot(reference, callBack)

    /**
     * Set up a snapshot listener that triggers every time there is a change on the reference from receiver
     * @receiver FirestoreCollectionReference
     * @param callBack Promise<FirestoreDocSnapshot>.() -> Unit
     * @return () -> Unit = Unsubscribe function
     */
    fun FirestoreCollectionReference.onSnapshot(callBack: Promise<FirestoreDocSnapshot>.() -> Unit) : () -> Unit = firebase.wrappers.firestore.onSnapshot(this, callBack)

    /**
     * Set up a snapshot listener that triggers every time there is a change on the specified query reference
     * @param query Query
     * @param callBack FirestoreDocSnapshot.() -> Unit
     * @return () -> Unit = Unsubscribe function
     */
    fun onSnapshot(query: Query, callBack: FirestoreDocSnapshot.() -> Unit) : () -> Unit = firebase.wrappers.firestore.onSnapshot(query, callBack)

    /**
     * Set up a snapshot listener that triggers every time there is a change on the query reference from receiver
     * @receiver Query
     * @param callBack FirestoreDocSnapshot.() -> Unit
     * @return () -> Unit = Unsubscribe function
     */
    fun Query.onSnapshot(callBack: FirestoreDocSnapshot.() -> Unit) : () -> Unit = firebase.wrappers.firestore.onSnapshot(this, callBack)

    //Fields
    /**
     * provide a value that tells the database to put a server timestamp in the field
     * @return FieldValue
     */
    fun serverTimestamp() : FieldValue = firebase.wrappers.firestore.serverTimestamp()

    /**
     * Provides a value that tells the database to remove the field
     * @return FieldValue
     */
    fun deleteField() : FieldValue = firebase.wrappers.firestore.deleteField()

    /**
     * Provides a value that tells the database to increment the value of the field
     * @param amount Int
     * @return FieldValue
     */
    fun increment(amount: Int) : FieldValue = firebase.wrappers.firestore.increment(amount)

    /**
     * Provides a value that tells the database to remove certain values from the array field
     * @param elements Array<out Any>
     * @return FieldValue
     */
    fun arrayRemove(vararg elements: Any) : FieldValue = firebase.wrappers.firestore.arrayRemove(elements)

    /**
     * Provides a value that tells the database to combine the values into the current array field
     * @param elements Array<out Any>
     * @return FieldValue
     */
    fun arrayUnion(vararg elements: Any) : FieldValue = firebase.wrappers.firestore.arrayUnion(elements)
}

