package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Half.toFloat
import android.widget.EditText
import android.widget.TextView
import kotlin.Unit.toString


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }
}

fun setListeners() {
        val editTextAltura : EditText = findViewById(R.id.edt_altura)
        val editTextPeso : EditText = findViewById<EditText>(R.id.edt_peso)
        val textViewResultado : TextView
        val altura = editTextAltura.getText()
        val peso = editTextPeso.getText()

        val calcularIMC = peso.times(altura.times(altura))
        textViewResultado.text = toString(calcularIMC)

    }

/*
private fun calcularIMC(altura: Float, peso: Float) : CharSequence {
    return calcularIMC() = peso.times (altura.times(altura))

}
*/
