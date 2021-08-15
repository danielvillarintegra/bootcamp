package br.com.danielvillarintegra.vmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var txtContador: EditText
    lateinit var btnDados: Button
    lateinit var btnMostrar:Button
    var contador : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDados()
        initContador()
        initClick()
        validaContador()
        logar(valor = "ONCREATE")

    }

    override fun onStart() {
        super.onStart()
        logar(valor = "ONSTART")

    }

    override fun onResume() {
        super.onResume()
        logar(valor = "ONRESUME")

    }

    override fun onPause() {
        super.onPause()
        logar(valor = "PAUSE")

    }

    override fun onStop() {
        super.onStop()
        logar(valor = "ONSTOP")

    }

    override fun onDestroy() {
        super.onDestroy()
        logar(valor = "ONDESTROY")

    }

    private fun logar(tag:String = "Ciclo de vida", valor:String) {
        Log.d(tag,valor)
    }

    private fun validaContador() {
        if (contador > 5) {
            contador = 0
        }
    }

    private fun initClick() {
        btnDados.setOnClickListener {
            contador++
            validaContador()
            initContador()
        }

        btnMostrar.setOnClickListener{
            Toast.makeText(this,
                "Valor contador: ${contador.toString()}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initContador(){
        txtContador.setText(contador.toString())
    }

    private fun initDados(){
        txtContador = findViewById(R.id.etContador)
        btnDados = findViewById(R.id.btnDados)
        btnMostrar = findViewById(R.id.btnMostrar)
    }


}