package com.example.imc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.imc2.R.layout.result_main

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(result_main)
        setListeners()
    }

    private fun setListeners() {
        val peso = 1.79F
        val altura = 82.0F
        val resultado : Float

        resultado = peso.div((altura * altura))

        tvw   .doAffterTextChanged {text ->
            Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()

        }
        edt_altura
        edt_peso.doOntextChanged { text, _, _, _ -> title}
    }
}