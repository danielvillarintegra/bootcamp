package br.com.danielvillarintegra.optionsmenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun showToast(message : String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_menu_1 -> {
                showToast("Exibindo menu 1")
                true
            }
            R.id.item_menu_2 -> {
                showToast("Exibindo menu 2")
                true
            }
            R.id.item_menu_3 -> {
                showToast("Exibindo menu 3")
                true
            }
            R.id.item_menu_4 -> {
                showToast("Exibindo menu 4")
                true
            }
            R.id.item_menu_5 -> {
                showToast("Exibindo menu 5")
                true
            }
            R.id.item_menu_6 -> {
                showToast("Exibindo menu 6")
                true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }
}