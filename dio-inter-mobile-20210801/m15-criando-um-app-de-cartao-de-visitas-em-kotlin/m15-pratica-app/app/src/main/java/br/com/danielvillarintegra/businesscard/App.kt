package br.com.danielvillarintegra.businesscard

import android.app.Application
import br.com.danielvillarintegra.businesscard.data.AppDatabase
import br.com.danielvillarintegra.businesscard.data.BusinessCardRepository

class App : Application() {

    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}