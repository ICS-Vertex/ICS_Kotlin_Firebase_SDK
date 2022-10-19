package firebase.config.classes

class FirebaseClientInfo {
    var mobilesdk_app_id: String = ""
    private var android_client_info: AndroidClientInfo =
        AndroidClientInfo()

    fun androidClientInfo(androidClientInfo: AndroidClientInfo.() -> Unit){
        android_client_info.apply { androidClientInfo }
    }
}