package br.com.danielvillarintegra.aplicationnotificationfb

import android.util.Log
import com.google.firebase.installations.FirebaseInstallations

//class MyFirebaseInstanceIdService : FirebaseInstanceIdService() {
class MyFirebaseInstanceIdService : FirebaseInstanceIdService //FirebaseInstallations() { //FirebaseInstanceIdService()
    FirebaseInstanceIdService
    override fun onTokenRefreh() {
        //Log.i( "**newTokenService", FirebaseInstanceId.getInstance().token().toString())
        Log.i("**newTokenService", getInstance().getToken().toString())
    }

}