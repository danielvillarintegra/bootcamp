package com.example.imc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var btCalcular:Button
    lateinit var etAltura:EditText
    lateinit var etPeso:EditText
    lateinit var tvResultado:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDados()
        initCalcular()
        initClick()
    }
    
    private fun initClick() {
        btCalcular.setOnClickListener {
            initCalcular()
            Toast.makeText(
                this,
                "Cálculo IMC: ${tvResultado.text}",
                Toast.LENGTH_SHORT)
                .show()
        }
    }


    private fun initDados(){
        etAltura = findViewById(R.id.etAltura)
        etPeso = findViewById(R.id.etPeso)
        btCalcular = findViewById(R.id.btCalcular)
        tvResultado = findViewById(R.id.tvResultado)
    }

    private fun Listeners() {

        btCalcular.setOnClickListener() {
        }
    }


    private fun initCalcular() {
        val altura : Float
        val peso : Float

        if (!etAltura.text.isNullOrBlank()) altura = etAltura.text.toString().toFloat()
            else altura = 0.0F

        if (!etPeso.text.isNullOrBlank()) peso = etPeso.text.toString().toFloat()
            else peso = 1.0F

        val calcularIMC = (peso.div(altura.times(altura)))

        var resultadoTabela: String
        tvResultado.text = "$calcularIMC"


        when (tvResultado.text.toString().toFloat()) {
            in 16.0F .. 16.9F  -> {
                resultadoTabela = "Muito abaixo do peso:"
            }

            in 17.0F .. 18.4F  -> {
                resultadoTabela ="Abaixo do peso:"
            }

            in 18.5F .. 24.9F  -> {
                resultadoTabela = "Normal:"
            }

            in 25.0F .. 29.9F  -> {
                resultadoTabela = "Acima do peso:"
            }

            in 30.0F .. 34.9F  -> {
                resultadoTabela = "Obesidade grau 1:"
            }

            in 35.0F .. 40.0F  -> {
                resultadoTabela = "Obesidade grau 2:"
            }
            else -> {
                if (calcularIMC > 40.0F) resultadoTabela = "Obesidade grau 3:"
                else resultadoTabela = "Fora da tabela:"
            }
        }
        resultadoTabela = "$resultadoTabela  "+ String.format("%.1f", calcularIMC)

        tvResultado.setText(resultadoTabela).toString()

        Toast.makeText(
            this,
            "$resultadoTabela",
            Toast.LENGTH_LONG)
            .show()
    }

}
    /*private fun setListeners() {

        etAltura.addTextChangedListener(object : TextWatcher {
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

        etPeso.addTextChangedListener(object : TextWatcher {
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

        btCalcular.setOnClickListener() {
            val alturaString : String = findViewById(edAltura).text.toString()
            val pesoString : String = etPeso.text.toString()
            val pesoFloat : Float
            val alturaFloat : Float
            val calcularIMC : Float


         *//*   alturaFloat = 1.79F
            pesoFloat = 84.0F
           *//*
            alturaFloat = alturaString.toFloat()
            pesoFloat = pesoString.toFloat()
            calcularIMC = (pesoFloat.div(alturaFloat.times(alturaFloat)))

            *//*Incluir arredondamento 1 casa decimal *//*
            *//* Talvez converter o float para String e depois arredondar ?

             *//*
            var resultadoTabela = String.format("%.1f", calcularIMC)

            tvResultado.setText("$calcularIMC").toString()


            when ((resultadoTabela).toDouble()) {
                in 16.0 .. 16.9  -> {
                    resultadoTabela = "Muito abaixo do peso: $calcularIMC"
                }

                in 17.0 .. 18.4  -> {
                    resultadoTabela ="Abaixo do peso: $calcularIMC"
                }

                in 18.5 .. 24.9  -> {
                    resultadoTabela = "Normal: $calcularIMC"
                }

                in 25.0 .. 29.9  -> {
                    resultadoTabela = "Acima do peso: $calcularIMC"
                }

                in 30.0 .. 34.9  -> {
                resultadoTabela = "Obesidade grau 1: $calcularIMC"
                }

                in 35.0 .. 40.0  -> {
                resultadoTabela = "Obesidade grau 2: $calcularIMC"
                }

            else -> {
                    if (((resultadoTabela).toDouble()) > 40.0) resultadoTabela = "Obesidade grau 3: $calcularIMC"
                    else resultadoTabela = "Fora da tabela: $calcularIMC"
                }
            }

            tvResultado.setText(resultadoTabela).toString()

        }

    }*/



