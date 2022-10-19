package firebase.config.classes

class FirebaseServices {
    var appinvite_service: AppInviteService = AppInviteService()

    fun appInviteService(inviteService: AppInviteService.() -> Unit){
        appinvite_service.apply { inviteService }
    }
}