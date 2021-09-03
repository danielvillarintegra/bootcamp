package br.com.danielvillarintegra.agendabootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract.CONTENT_URI
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSetEvent = findViewById<Button>(R.id.btn_set_event)
        btnSetEvent.setOnClickListener{
           val intent = Intent(Intent.ACTION_INSERT)
               .setData(CONTENT_URI)
        }

    }
}