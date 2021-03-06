package br.com.danielvillarintegra.vmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel: ViewModel() {
    var mContador = MutableLiveData<String>().apply { value = contador.toString() }
    private var contador : Int = 0

    private fun setmContador() {
        mContador.value = contador.toString()
    }

    private fun validaContador() {
        contador++
        if (contador > 5) {
            contador = 0
        }
        setmContador()
    }

    //NÃO PODE SER PRIVADO
    fun Contador() {
        validaContador()
    }

}