package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("Lifecycle", "CREATE - estou criando a tela")
    }

    override fun onStart() {
        super.onStart()
        Log.w("Lifecycle", "START - deixei a tela visivel")

    }

    override fun onPause() {
        super.onPause()
        Log.w("Lifecycle", "PAUSE - a tela perdeu o foco, vc não pode mais interagir")

    }

    override fun onStop() {
        Log.w("Lifecycle", "STOP - a tela não está mais visivel mas ainda existe")
        super.onStop()

    }

    override fun onDestroy() {
        Log.w("Lifecycle", "DESTROY - oh não ! a tela foi destruída")
        super.onDestroy()

    }

    override fun onRestart() {
        Log.w("Lifecycle", "\nRESTART - a tela está retomando o foco")
        super.onRestart()

    }


}