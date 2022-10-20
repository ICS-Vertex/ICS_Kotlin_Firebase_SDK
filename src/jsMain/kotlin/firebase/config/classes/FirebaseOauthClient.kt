// Copyright 2022 ICS Vertex
package firebase.config.classes

class FirebaseOauthClient {
    var client_id: String = ""
    var client_type: Int = 1
    var android_info: AndroidInfo? = AndroidInfo()

    fun androidInfo(androidInfo: AndroidInfo.() -> Unit){
        android_info.apply { androidInfo }
    }
}