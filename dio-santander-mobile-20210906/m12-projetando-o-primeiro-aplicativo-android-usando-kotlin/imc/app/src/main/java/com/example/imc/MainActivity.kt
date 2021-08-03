package com.example.imc

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {

        edt_altura.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(
                    applicationContext,
                    "executed before making any change over EditText + $p0",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(
                    applicationContext,
                    "executed while making any change over EditText  + $p0",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun afterTextChanged(p0: Editable?) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(
                    applicationContext,
                    "executed after change made over EditText + $p0",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        edt_peso.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(
                    applicationContext,
                    "Peso: executado antes de fazer alguma alteração sobre EditText",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(
                    applicationContext,
                    "Peso: executado enquanto faz qualquer alteração sobre o EditText",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun afterTextChanged(p0: Editable?) {
                //  TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                Toast.makeText(
                    applicationContext,
                    "Peso: executado após as alterações feitas sobre o EditText",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

        btn_calcular.setOnClickListener() {
            val alturaString : String = edt_altura.text.toString()
            val pesoString : String = edt_peso.text.toString()
            var resultadoTabela: String = ""
            var pesoFloat : Float
            var alturaFloat : Float
            var calcularIMC : Float = 0.0F

         /*   alturaFloat = 1.79F
            pesoFloat = 84.0F
           */
            alturaFloat = alturaString.toFloat()
            pesoFloat = pesoString.toFloat()
            calcularIMC = pesoFloat.div(alturaFloat.times(alturaFloat))

            /*Incluir arredondamento 1 casa decimal */


            tvw_resultado2.setText("$pesoFloat").toString()
            tvw_resultado_anterior.setText("$calcularIMC").toString()
            tvw_resultado.setText("$calcularIMC").toString()


            when (calcularIMC) {
                in 16.0 .. 16.9  -> {
                    resultadoTabela = "Muito abaixo do peso: $calcularIMC"
                    tvw_resultado.setText(resultadoTabela).toString()
                }

                in 17.0 .. 18.4  -> {
                    tvw_resultado.setText("Abaixo do peso: $calcularIMC").toString()
                }

                in 18.5 .. 24.9  -> {
                    resultadoTabela = "Normal: $calcularIMC"
                    tvw_resultado.setText(resultadoTabela).toString()
                }

                in 25.0 .. 29.9  -> {
                    resultadoTabela = "Acima do peso: $calcularIMC"
                    tvw_resultado.setText(resultadoTabela).toString()
                }

                in 30.0 .. 34.9  -> {
                resultadoTabela = "Obesidade grau 1: $calcularIMC"
                tvw_resultado.setText(resultadoTabela).toString()
                }

                in 35.0 .. 40.0  -> {
                resultadoTabela = "Obesidade grau 2: $calcularIMC"
                tvw_resultado.setText(resultadoTabela).toString()
                }

                in 40.0 .. 50.0 -> {
                resultadoTabela = "Obesidade grau 3: $calcularIMC"
                tvw_resultado.setText(resultadoTabela).toString()
                }
            else -> {
                resultadoTabela = "Fora da tabela: $calcularIMC"
                }
            }
            tvw_resultado_anterior.setText("$calcularIMC").toString()
            tvw_resultado.setText(resultadoTabela).toString()

        }

    }
}


