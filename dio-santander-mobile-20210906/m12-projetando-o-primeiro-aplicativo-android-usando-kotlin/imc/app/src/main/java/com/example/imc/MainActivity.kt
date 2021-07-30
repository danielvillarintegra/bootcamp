package com.example.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Half.toFloat
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
}

    fun setListeners() {
        val editTextAltura : Float? = this.findViewById<EditText>(R.id.edt_altura)
        val editTextPeso : Float? = findViewById<EditText>(R.id.edt_peso)
        val textViewResultado : Float

        this.toString( calcularIMC(editTextAltura, editTextPeso))
            .also { findViewById<TextView>(R.id.tvw_resultado) = it }
    }

}

private fun calcularIMC(altura: Float, peso: EditText) : Float {
    return calcularIMC() = peso.times (altura.times(altura))

}