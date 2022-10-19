@file:JsModule("firebase/storage")
@file:JsNonModule

package firebase.wrappers.storage

import firebase.wrappers.FirebaseAppImpl
import firebase.wrappers.storage.classes.core.StorageFile
import firebase.wrappers.storage.classes.core.StorageImpl
import firebase.wrappers.storage.classes.core.StorageList
import firebase.wrappers.storage.classes.core.StorageReference
import org.khronos.webgl.ArrayBuffer
import org.w3c.files.Blob
import org.w3c.files.File
import kotlin.js.Promise

external fun getStorage(app: FirebaseAppImpl, bucket: String) : StorageImpl
external fun getStorage(app: FirebaseAppImpl) : StorageImpl
external fun getStorage() : StorageImpl

external fun ref(storage: StorageImpl) : StorageReference
external fun ref(storage: StorageImpl, paths: String) : StorageReference
external fun ref(reference: StorageReference) : StorageReference
external fun ref(reference: StorageReference, paths: String) : StorageReference

external fun uploadBytes(reference: StorageReference, file: File) : Promise<StorageFile>
external fun uploadString(reference: StorageReference, String: String, type: String) : Promise<StorageFile>

external fun getDownloadURL(reference: StorageReference) : Promise<String>
external fun getBlob(reference: StorageReference) : Promise<Blob>
external fun getBytes(reference: StorageReference) : Promise<ArrayBuffer>

external fun deleteObject(reference: StorageReference) : Promise<*>

external fun listAll(reference: StorageReference) : Promise<StorageList>