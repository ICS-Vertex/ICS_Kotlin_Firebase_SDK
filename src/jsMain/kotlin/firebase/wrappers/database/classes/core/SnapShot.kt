// Copyright 2022 ICS Vertex
package firebase.wrappers.database.classes.core


import kotlinx.js.Object
import kotlin.js.Json

external class SnapShot {
    fun exists() : Boolean

    @JsName("val")
    fun <T> value(): T
    @JsName("val")
    fun value(): Json
}

fun <T> SnapShot.forEach(action: (T) -> Unit){
    val values = this.value()
    val keys = Object.keys(values)
    keys.forEach {
        values[it].unsafeCast<T>().apply(action)
    }
}

fun SnapShot.forEach(action: (Json) -> Unit){
    val values = this.value()
    val keys = Object.keys(values)
    keys.forEach {
        values[it].unsafeCast<Json>().apply(action)
    }
}