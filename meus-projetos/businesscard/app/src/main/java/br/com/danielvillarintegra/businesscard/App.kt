package br.com.danielvillarintegra.businesscard

import android.app.Application
import br.com.danielvillarintegra.businesscard.data.AppDatabase
import br.com.danielvillarintegra.businesscard.data.BusinessCardRepository

class App : Application() {

    private val database by lazy { AppDatabase.getDatabase(this) } // Instancia o Room
    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}