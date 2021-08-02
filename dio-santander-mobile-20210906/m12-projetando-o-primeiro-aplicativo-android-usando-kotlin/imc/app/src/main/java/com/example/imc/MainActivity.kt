package com.example.imc

import android.os.Bundle
import android.util.Half.toFloat
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        val alturaString : String = edt_altura.text.toString()
        val pesoString : String = edt_peso.text.toString()
        var pesoFloat : Float = 0.0F
        var alturaFloat : Float = 0.0F
        var calcularIMC : Float = 0.0F

        /*
        edt_altura.doAfterTextChanged {
            if (alturaString.isNullOrEmpty() == false) {
                Toast.makeText(
                    this,
                    "please input data, edit text cannot be blank",
                    Toast.LENGTH_LONG
                ).show()
                tvw_resultado1.setText("= " + alturaString).toString()
            } else {
                alturaFloat = alturaString.toFloat()
                tvw_resultado1.setText("Altura = " + alturaString).toString()
            }
        }

        edt_peso.doAfterTextChanged {
            if (pesoString.isNullOrEmpty() == false) {
                Toast.makeText(
                    this,
                    "please input data, edit text cannot be blank",
                    Toast.LENGTH_LONG
                ).show()
                tvw_resultado2.setText("= " + pesoString).toString()
            } else {
                pesoFloat = pesoString.toFloat()
                tvw_resultado2.setText("Peso = " + pesoString).toString()
            }
        }
        */


        btn_calcular.setOnClickListener() {
            alturaFloat = 1.79F
            pesoFloat = 84.0F
            calcularIMC = pesoFloat.div(alturaFloat.times(alturaFloat))
            tvw_resultado1.setText("$alturaFloat").toString()
            tvw_resultado2.setText("$pesoFloat").toString()
            tvw_resultado.setText("$calcularIMC").toString()

        }

    }
}


