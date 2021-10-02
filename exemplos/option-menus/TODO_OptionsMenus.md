Options Menus:

Vídeo aula original do instrutor Igor Ferrani, nos bootcamps do Santander mobile, Inter e Carrefour dentro da plataforma da Digital Innovation One.

São menus comums que aparecem no aplicativos do lado direito (exemplo menu more - acrescentar ícone dos três pontinho verticais)

 

Em java/res criar um novo criar um novo diretório chamado "menu"  clicando com o botão direito do mouse e escolhendo "New" + "Android Resource Directory".

Em java/res/menu criar o "menu" (ícone dos três pontinhos vertical - more)  clicando com o botão direito do mouse e escolhendo "New" + "Menu Resource file"

Código do arquivo menu.xml
<?xml version="1.0" encoding="utf-8"?>

<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/item_menu_1"
        android:title="@string/item_menu_1" />
    <item
        android:id="@+id/item_menu_2"
        android:title="@string/item_menu_2" />
    <item
        android:id="@+id/item_menu_3"
        android:title="@string/item_menu_3" />
    <item
        android:id="@+id/item_menu_4"
        android:title="@string/item_menu_4" />
    <item
        android:id="@+id/item_menu_5"
        android:title="@string/item_menu_5" />
    <item
        android:id="@+id/item_menu_6"
        android:title="@string/item_menu_6" />
</menu>





Código do arquivo menu.xml
< ?xml version="1.0" encoding="utf-8"? >

<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/item_menu_1"
        android:title="@string/item_menu_1" />
    <item
        android:id="@+id/item_menu_2"
        android:title="@string/item_menu_2" />
    <item
        android:id="@+id/item_menu_3"
        android:title="@string/item_menu_3" />
    <item
        android:id="@+id/item_menu_4"
        android:title="@string/item_menu_4" />
    <item
        android:id="@+id/item_menu_5"
        android:title="@string/item_menu_5" />
    <item
        android:id="@+id/item_menu_6"
        android:title="@string/item_menu_6" />
</menu>



Arquivo strings.xml

```kotlin
<resources>
    <string name="app_name">NavigationDrawer</string>
    <string name="item_menu_1">Compartilhar</string>
    <string name="item_menu_2">Editar</string>
    <string name="item_menu_3">Excluir</string>
    <string name="item_menu_4">Buscar</string>
    <string name="item_menu_5">Ligar</string>
    <string name="item_menu_6">Favoritar</string>
</resources>
```

Arquivo themes.xml

```kotlin
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.NavigationDrawer" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/purple_500</item>
        <item name="colorPrimaryVariant">@color/purple_700</item>
        <item name="colorOnPrimary">@color/white</item>
        <!-- Secondary brand color. -->
        <item name="colorSecondary">@color/teal_200</item>
        <item name="colorSecondaryVariant">@color/teal_700</item>
        <item name="colorOnSecondary">@color/black</item>
        <!-- Status bar color. -->
        <item name="android:statusBarColor" tools:targetApi="l">?attr/colorPrimaryVariant</item>
        <!-- Customize your theme here. -->
    </style>
</resources>
```



Arquivo activity_mail.xml

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

Em MainActivity.kt

```kotlin
package br.com.danielvillarintegra.navigationdrawer

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
```

