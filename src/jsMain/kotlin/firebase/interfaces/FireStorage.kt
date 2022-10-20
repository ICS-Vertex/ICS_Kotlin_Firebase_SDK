// Copyright 2022 ICS Vertex
package firebase.interfaces

import firebase.wrappers.FirebaseAppImpl
import firebase.wrappers.storage.classes.core.StorageFile
import firebase.wrappers.storage.classes.core.StorageImpl
import firebase.wrappers.storage.classes.core.StorageList
import firebase.wrappers.storage.classes.core.StorageReference
import firebase.wrappers.storage.enums.UploadType
import org.khronos.webgl.ArrayBuffer
import org.w3c.files.Blob
import org.w3c.files.File
import kotlin.js.Promise

/**
 * Interface to communicate with the firebase storage api
 * @author Mike Dirven
 */
interface FireStorage {
    /**
     * Initialize firebase storage from global firebase implementation
     * @return StorageImpl
     */
    fun getStorage() : StorageImpl = firebase.wrappers.storage.getStorage()

    /**
     * Initialize firebase storage from specific firebase implementation
     * @param app The firebase implementation
     * @return StorageImpl
     */
    fun getStorage(app: FirebaseAppImpl) : StorageImpl = firebase.wrappers.storage.getStorage(app)

    /**
     * Initialize firebase storage from specific firebase implementation
     * with custom bucket
     * @param app The firebase implementation
     * @param bucket The bucket location
     * @return StorageImpl
     */
    fun getStorage(app: FirebaseAppImpl, bucket: String) : StorageImpl
        = firebase.wrappers.storage.getStorage(app, bucket)

    /**
     * Initialize firebase storage from receiver firebase implementation
     * @receiver FirebaseAppImpl
     * @return StorageImpl
     */
    fun FirebaseAppImpl.getStorage() : StorageImpl = firebase.wrappers.storage.getStorage(this)

    /**
     * Initialize firebase storage from receiver firebase implementation
     * with custom bucket
     * @receiver FirebaseAppImpl
     * @param bucket The bucket location
     * @return StorageImpl
     */
    fun FirebaseAppImpl.getStorage(bucket: String) : StorageImpl
        = firebase.wrappers.storage.getStorage(this, bucket)

    //Ref
    /**
     * Get the root reference of the firebase storage
     * @param storage StorageImpl
     * @return StorageReference
     */
    fun ref(storage: StorageImpl) : StorageReference = firebase.wrappers.storage.ref(storage)

    /**
     * Get a reference from a path in the firebase storage
     * Example paths:
     *
     *    ("location", "current")
     *    ("location/current")
     * @param storage StorageImpl
     * @param paths Array<out String>
     * @return StorageReference
     */
    fun ref(storage: StorageImpl, vararg paths: String) : StorageReference
        = firebase.wrappers.storage.ref(storage, paths.joinToString("/"))

    /**
     * Get the root reference of the firebase storage
     * @receiver StorageImpl
     * @return StorageReference
     */
    fun StorageImpl.ref() : StorageReference = firebase.wrappers.storage.ref(this)

    /**
     * Get a reference from a path in the firebase storage
     * Example paths:
     *
     *    ("location", "current")
     *    ("location/current")
     * @receiver StorageImpl
     * @param paths Array<out String>
     * @return StorageReference
     */
    fun StorageImpl.ref(vararg paths: String) : StorageReference
        = firebase.wrappers.storage.ref(this, paths.joinToString("/"))

    /**
     * Get the root reference of the current StorageReference
     * @receiver StorageReference
     * @return StorageReference
     */
    fun StorageReference.ref() : StorageReference = firebase.wrappers.storage.ref(this)

    /**
     * Get a reference from a path in the firebase storage from the current StorageReference
     * Example paths:
     *
     *    ("location", "current")
     *    ("location/current")
     * @receiver StorageReference
     * @param paths Array<out String>
     * @return StorageReference
     */
    fun StorageReference.ref(vararg paths: String) : StorageReference
        = firebase.wrappers.storage.ref(this, paths.joinToString("/"))

    //UploadBytes
    /**
     * Upload File to the firebase storage on the specified reference
     * @param reference StorageReference
     * @param file File
     * @return Promise<StorageFile>
     */
    fun uploadBytes(reference: StorageReference, file: File) : Promise<StorageFile>
        = firebase.wrappers.storage.uploadBytes(reference, file)

    /**
     * Upload file to the firebase storage on the storage reference of the receiver
     * @receiver StorageReference
     * @param file File
     * @return Promise<StorageFile>
     */
    fun StorageReference.uploadBytes(file: File) : Promise<StorageFile>
        = firebase.wrappers.storage.uploadBytes(this, file)

    //UploadString
    /**
     * Upload a string to the firebase storage on the specified StorageReference with the specified uploadType.
     *
     * @param reference StorageReference
     * @param string String
     * @param type UploadType
     * @return Promise<StorageFile>
     */
    fun uploadString(reference: StorageReference, string: String, type: UploadType) : Promise<StorageFile>
        = firebase.wrappers.storage.uploadString(reference, string, type.value)

    /**
     * Upload a string to the firebase storage on the StorageReference of the receiver with the specified uploadType
     * @receiver StorageReference
     * @param string String
     * @param type UploadType
     * @return Promise<StorageFile>
     */
    fun StorageReference.uploadString(string: String, type: UploadType) : Promise<StorageFile> = firebase.wrappers.storage.uploadString(this, string, type.value)

    //Download
    /**
     * Get the download url for the specified StorageReference
     * @param reference StorageReference
     * @return Promise<String>
     */
    fun getDownloadURL(reference: StorageReference) : Promise<String> = firebase.wrappers.storage.getDownloadURL(reference)

    /**
     * Get the download url for the StorageReference of the receiver
     * @receiver StorageReference
     * @return Promise<String>
     */
    fun StorageReference.getDownloadURL() : Promise<String> = firebase.wrappers.storage.getDownloadURL(this)

    /**
     * Directly download the file as Blob from the specified StorageReference
     * @param reference StorageReference
     * @return Promise<Blob>
     */
    fun getBlob(reference: StorageReference) : Promise<Blob> = firebase.wrappers.storage.getBlob(reference)

    /**
     * Directly download the file as Blob from the StorageReference of the receiver
     * @receiver StorageReference
     * @return Promise<Blob>
     */
    fun StorageReference.getBlob() : Promise<Blob> = firebase.wrappers.storage.getBlob(this)

    /**
     * Directly download the file as Bytes from the specified StorageReference
     * @param reference StorageReference
     * @return Promise<ArrayBuffer>
     */
    fun getBytes(reference: StorageReference) : Promise<ArrayBuffer> = firebase.wrappers.storage.getBytes(reference)

    /**
     * Directly download the file as Bytes from the StorageReference fro mthe receiver
     * @receiver StorageReference
     * @return Promise<ArrayBuffer>
     */
    fun StorageReference.getBytes() : Promise<ArrayBuffer> = firebase.wrappers.storage.getBytes(this)

    //Delete
    /**
     * Delete the file from the specified StorageReference
     * @param reference StorageReference
     * @return Promise<*>
     */
    fun deleteObject(reference: StorageReference) : Promise<*> = firebase.wrappers.storage.deleteObject(reference)

    /**
     * Delete the file from the StorageReference of the receiver
     * @receiver StorageReference
     * @return Promise<*>
     */
    fun StorageReference.deleteObject() : Promise<*> = firebase.wrappers.storage.deleteObject(this)

    //Listing
    /**
     * List all folders and files present at the specified StorageReference
     * @param reference StorageReference
     * @return Promise<StorageList>
     */
    fun listAll(reference: StorageReference) : Promise<StorageList> = firebase.wrappers.storage.listAll(reference)

    /**
     * List all folders and files present at the StorageReference from the receiver
     * @receiver StorageReference
     * @return Promise<StorageList>
     */
    fun StorageReference.listAll() : Promise<StorageList> = firebase.wrappers.storage.listAll(this)
}