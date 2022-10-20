// Copyright 2022 ICS Vertex
package firebase.config.classes

class AppInviteService {
    private var other_platform_oauth_client: MutableList<FirebaseOauthClient> = mutableListOf()

    fun addPlatformOauthClient(oauthClient: FirebaseOauthClient.() -> Unit){
        other_platform_oauth_client.add(FirebaseOauthClient().apply{ oauthClient })
    }
}