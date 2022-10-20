// Copyright 2022 ICS Vertex
package firebase.interfaces

import firebase.wrappers.FirebaseAppImpl
import firebase.wrappers.database.classes.core.*
import firebase.wrappers.database.classes.fields.FieldValue
import kotlinx.js.jso
import kotlin.js.Promise

/**
 * Interface to communicate with the firebase realtime database api
 * @author Mike Dirven
 */
interface RealTimeDatabase {
    /**
     * Initialize firebase realtime database from global firebase implementation
     * @return DatabaseImpl
     */
    fun getDatabase() : DatabaseImpl = firebase.wrappers.database.getDatabase()

    /**
     * Initialize firebase realtime database from specified firebase implementation
     * @param app FirebaseAppImpl
     * @return DatabaseImpl
     */
    fun getDatabase(app: FirebaseAppImpl) : DatabaseImpl = firebase.wrappers.database.getDatabase(app)

    /**
     * Initialize firebase realtime database on firebase implementation from receiver
     * @receiver FirebaseAppImpl
     * @return DatabaseImpl
     */
    fun FirebaseAppImpl.getDatabase() : DatabaseImpl = firebase.wrappers.database.getDatabase(this)

    /**
     * Get a reference from the specified database on the specified path
     * @param database DatabaseImpl
     * @param references Array<out String>
     * @return DatabaseReference
     */
    fun ref(database: DatabaseImpl, vararg references: String) : DatabaseReference = firebase.wrappers.database.ref(database, references.joinToString("/"))

    /**
     * Get a reference from the specified database on the specified path
     * @param database DatabaseImpl
     * @param references String
     * @return DatabaseReference
     */
    fun ref(database: DatabaseImpl, references: String) : DatabaseReference = firebase.wrappers.database.ref(database, references)

    /**
     * Get a reference from the database from the receiver on the specified path
     * @receiver DatabaseImpl
     * @param references Array<out String>
     * @return DatabaseReference
     */
    fun DatabaseImpl.ref(vararg references: String) : DatabaseReference = firebase.wrappers.database.ref(this, references.joinToString("/"))

    /**
     * Get a reference from the database from the receiver on the specified path
     * @receiver DatabaseImpl
     * @param references String
     * @return DatabaseReference
     */
    fun DatabaseImpl.ref(references: String) : DatabaseReference = firebase.wrappers.database.ref(this, references)

    /**
     * Get a child reference on specified reference from path
     * @param reference DatabaseReference
     * @param path Array<out String>
     * @return DatabaseReference
     */
    fun child(reference: DatabaseReference, vararg path: String) : DatabaseReference = firebase.wrappers.database.child(reference, path.joinToString("/"))

    /**
     * Get a child reference on specified reference from path
     * @param reference DatabaseReference
     * @param path String
     * @return DatabaseReference
     */
    fun child(reference: DatabaseReference, path: String) : DatabaseReference = firebase.wrappers.database.child(reference, path)

    /**
     * Get a child reference on reference from receiver to path
     * @receiver DatabaseReference
     * @param path Array<out String>
     * @return DatabaseReference
     */
    fun DatabaseReference.child(vararg path: String) : DatabaseReference = firebase.wrappers.database.child(this, path.joinToString("/"))

    /**
     * Get a child reference on reference from receiver to path
     * @receiver DatabaseReference
     * @param path String
     * @return DatabaseReference
     */
    fun DatabaseReference.child(path: String) : DatabaseReference = firebase.wrappers.database.child(this, path)

    /**
     * Execute query on specified reference
     * @param reference DatabaseReference
     * @param queries Array<out QueryOption>
     * @return Query
     */
    fun query(reference: DatabaseReference, vararg queries: QueryOption) : Query = firebase.wrappers.database.query(reference, *queries)

    /**
     * Execute query on reference from receiver
     * @receiver DatabaseReference
     * @param queries Array<out QueryOption>
     * @return Query
     */
    fun DatabaseReference.query(vararg queries: QueryOption) : Query = firebase.wrappers.database.query(this, *queries)

    /**
     * Set data on specified reference from lambda
     * @param reference DatabaseReference
     * @param data T.() -> Unit
     * @return Promise<SnapShot>
     */
    fun <T: Any> set(reference: DatabaseReference, data: T.() -> Unit): Promise<SnapShot> = firebase.wrappers.database.set(reference, jso<T>().apply(data))

    /**
     * Set data on specified reference from data object
     * @param reference DatabaseReference
     * @param data T
     * @return Promise<SnapShot>
     */
    fun <T: Any> set(reference: DatabaseReference, data: T): Promise<SnapShot> = firebase.wrappers.database.set(reference, data)

    /**
     * Set data on reference from receiver from lambda
     * @receiver DatabaseReference
     * @param data T.() -> Unit
     * @return Promise<SnapShot>
     */
    fun <T: Any> DatabaseReference.set(data: T.() -> Unit): Promise<SnapShot> = firebase.wrappers.database.set(this, jso<T>().apply(data))

    /**
     * Set data on specified reference from data object
     * @receiver DatabaseReference
     * @param data T
     * @return Promise<SnapShot>
     */
    fun <T: Any> DatabaseReference.set(data: T): Promise<SnapShot> = firebase.wrappers.database.set(this, data)

    /**
     * Update data on specified reference from lamba
     * @param reference DatabaseReference
     * @param data T.() -> Unit
     * @return Promise<*>
     */
    fun <T: Any> update(reference: DatabaseReference, data: T.() -> Unit) : Promise<*> = firebase.wrappers.database.update(reference, jso<T>().apply(data))

    /**
     * Update data on specified reference from data object
     * @param reference DatabaseReference
     * @param data T
     * @return Promise<*>
     */
    fun <T: Any> update(reference: DatabaseReference, data: T) : Promise<*> = firebase.wrappers.database.update(reference, data)

    /**
     * Update data on reference from receiver from lambda
     * @receiver DatabaseReference
     * @param data T.() -> Unit
     * @return Promise<*>
     */
    fun <T: Any> DatabaseReference.update(data: T.() -> Unit) : Promise<*> = firebase.wrappers.database.update(this, jso<T>().apply(data))

    /**
     * update data on reference from receiver from data object
     * @receiver DatabaseReference
     * @param data T
     * @return Promise<*>
     */
    fun <T: Any> DatabaseReference.update(data: T) : Promise<*> = firebase.wrappers.database.update(this, data)

    /**
     * Remove specified reference
     * @param reference DatabaseReference
     * @return Promise<*>
     */
    fun remove(reference: DatabaseReference) : Promise<*> = firebase.wrappers.database.remove(reference)

    /**
     * Remove reference from receiver
     * @receiver DatabaseReference
     * @return Promise<*>
     */
    fun DatabaseReference.remove() : Promise<*> = firebase.wrappers.database.remove(this)

    /**
     * Provides a value that tells the database to input a server timestamp into the field
     * @return FieldValue
     */
    fun serverTimestamp() : FieldValue = firebase.wrappers.database.serverTimestamp()

    /**
     * Provides a value that tells the database to increment the current field value
     * @param amount Int
     * @return FieldValue
     */
    fun increment(amount: Int) : FieldValue = firebase.wrappers.database.increment(amount)

    /**
     * Get values from specified reference
     * @param reference DatabaseReference
     * @return Promise<SnapShot>
     */
    fun get(reference: DatabaseReference) : Promise<SnapShot> = firebase.wrappers.database.get(reference)

    /**
     * Get values from reference from receiver
     * @receiver DatabaseReference
     * @return Promise<SnapShot>
     */
    fun DatabaseReference.get() : Promise<SnapShot> = firebase.wrappers.database.get(this)

    /**
     * Get value from specified query reference
     * @param query Query
     * @return Promise<SnapShot>
     */
    fun get(query: Query) : Promise<SnapShot> = firebase.wrappers.database.get(query)

    /**
     * Get values from query reference from receiver
     * @receiver Query
     * @return Promise<SnapShot>
     */
    fun Query.get() : Promise<SnapShot> = firebase.wrappers.database.get(this)

    /**
     * Set up on value listener on the specified reference
     * Triggers every time there is a change in the values of the reference
     * @param reference DatabaseReference
     * @param callBack [@kotlin.ExtensionFunctionType] Function1<SnapShot, Unit>
     * @return () -> Unit
     */
    fun onValue(reference: DatabaseReference, callBack: SnapShot.() -> Unit) : () -> Unit = firebase.wrappers.database.onValue(reference, callBack)

    /**
     * Set up on value listener on reference from receiver
     * Triggers every time there is a change in the values of the reference
     * @receiver DatabaseReference
     * @param callBack [@kotlin.ExtensionFunctionType] Function1<SnapShot, Unit>
     * @return () -> Unit
     */
    fun DatabaseReference.onValue(callBack: SnapShot.() -> Unit) : () -> Unit = firebase.wrappers.database.onValue(this, callBack)
}