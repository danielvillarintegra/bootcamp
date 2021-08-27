package br.com.danielvillarintegra.aplicationnotificationfb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.google.firebase.installations.FirebaseInstallations
import com.google.firebase.installations.FirebaseInstallations.getInstance

class MainActivity : AppCompatActivity() {

    lateinit var btnSend:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSend = findViewById(R.id.button_send_notification)
        btnSend.setOnClickListener{
            this.showNotification("1234","bootcamp Android", "Kotlin Android curso")
        }
        // Log.i("**newToken", FirebaseInstanceId.getInstance().token.toString())
        Log.i("**newToken", FirebaseInstallations.getInstance().getToken().toString()
        )
    }
}