// Copyright 2022 ICS Vertex
package firebase.config.classes

class FirebaseClient {
    private var client_info: FirebaseClientInfo = FirebaseClientInfo()
    private var oauth_client: MutableList<FirebaseOauthClient> = mutableListOf()
    var api_key: MutableList<FirebaseApiKey> = mutableListOf()
    var services: FirebaseServices = FirebaseServices()

    fun clientInfo(clientInfo: FirebaseClientInfo.() -> Unit){
        client_info.apply { clientInfo }
    }

    fun oauthClient(oauthClient: FirebaseOauthClient.() -> Unit){
        oauth_client.add(FirebaseOauthClient().apply { oauthClient })
    }

    fun addApiKey(apiKey: FirebaseApiKey.() -> Unit){
        api_key.add(FirebaseApiKey().apply { apiKey })
    }

    fun services(servicesInfo: FirebaseServices.() -> Unit){
        services.apply { servicesInfo }
    }
}