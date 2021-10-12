package br.com.danielvillarintegra.webview

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView: WebView = findViewById(R.id.wv_webview)
        //myWebView.loadUrl("https://www.google.com")
        //myWebView.loadUrl("https://github.com/danielvillarintegra/BusinessCard/blob/main/README.md")
        myWebView.loadUrl("https://github.com/danielvillarintegra/bootcamp/blob/main/README.md")

    }

}