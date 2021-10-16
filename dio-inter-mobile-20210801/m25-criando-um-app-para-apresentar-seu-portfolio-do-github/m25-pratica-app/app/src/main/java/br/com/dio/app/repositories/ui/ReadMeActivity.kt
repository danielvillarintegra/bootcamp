package br.com.dio.app.repositories.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import br.com.dio.app.repositories.R

class ReadMeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_me)
        val myWebView: WebView = findViewById(R.id.wv_webview)
        val urlReadMe : String = intent.extras?.getString("url") ?: "Não encontrada"
        //myWebView.loadUrl("https://www.google.com")
        //myWebView.loadUrl("https://github.com/danielvillarintegra/BusinessCard/blob/main/README.md")
        myWebView.loadUrl(urlReadMe)
        Log.d("D/Sucesso"," ReadMe em $urlReadMe")
    }
}