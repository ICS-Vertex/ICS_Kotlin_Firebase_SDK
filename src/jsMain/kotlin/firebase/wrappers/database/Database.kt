// Copyright 2022 ICS Vertex
@file:JsModule("firebase/database")
@file:JsNonModule

package firebase.wrappers.database

import firebase.wrappers.FirebaseAppImpl
import firebase.wrappers.database.classes.core.*
import firebase.wrappers.database.classes.fields.FieldValue
import kotlin.js.Promise

external fun getDatabase(app: FirebaseAppImpl) : DatabaseImpl
external fun getDatabase() : DatabaseImpl

//Begin General
external fun orderByChild(child: String) : QueryOption
external fun orderByKey(key: String) : QueryOption
external fun orderByValue(value: String) : QueryOption
external fun limitToFirst(index: Int) : QueryOption
external fun limitToLast(index: Int) : QueryOption
external fun startAt(index: Int) : QueryOption
external fun startAfter(index: Int) : QueryOption
external fun endAt(index: Int) : QueryOption
external fun andBefore(index: Int) : QueryOption
external fun equalTo(index: Int) : QueryOption
//End General

//Begin Fields
external fun serverTimestamp() : FieldValue
external fun increment(amount: Int) : FieldValue
//End Fields

external fun ref(database: DatabaseImpl, reference: String) : DatabaseReference
external fun child(reference: DatabaseReference, path: String) : DatabaseReference
external fun query(reference: DatabaseReference, vararg queries: QueryOption) : Query

external fun <T> set(reference: DatabaseReference, data: T) : Promise<SnapShot>
external fun get(reference: DatabaseReference) : Promise<SnapShot>
external fun get(query: Query) : Promise<SnapShot>
external fun <T> update(reference: DatabaseReference, data: T) : Promise<*>
external fun remove(reference: DatabaseReference) : Promise<*>

external fun onValue(reference: DatabaseReference, callBack: Function<Any>) : () -> Unit