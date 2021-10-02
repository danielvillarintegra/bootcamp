Navigation Drawer:

Vídeo aula original do instrutor Igor Ferrani, nos bootcamps do Santander mobile, Inter e Carrefour dentro da plataforma da Digital Innovation One.



Aproveitar o código do OptionsMenus

São menus abertos a esquerda ou a direita nas telas principais ( incluir telas de exemplos )

Resumo: Criar um novo menu, reaproveitando o menu criado na aula de OptionsMenus e incluir o layout da Main Activity (activity_main.xml) nele.



Em java/res/layout, criar o "drawer_menu" clicando com o botão direito do mouse e escolhendo

"New" + "Layout Resource File"

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

</androidx.constraintlayout.widget.ConstraintLayout>
```

 e alterar o nome da viewroot:

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.drawerlayout.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

</androidx.drawerlayout.widget.DrawerLayout>
```



```Kotlin
android:id="@+id/drawer_layout"
```

Incluir o layout da main_activity no drawer_menu:

```kotlin
<include
    layout="@layout/activity_main" />
```

Acrescentar a navigationView

```kotlin
<com.google.android.material.navigation.NavigationView
    android:id="@+id/navi_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_gravity="start"
    app:menu="@menu/menu"
    />
```

Resultando em:

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.drawerlayout.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/drawer_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:openDrawer="start">

    <include
        layout="@layout/activity_main" />

    <com.google.android.material.navigation.NavigationView
        android:id="@+id/navi_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        app:menu="@menu/menu"
        />

</androidx.drawerlayout.widget.DrawerLayout>
```



Em java/res/values/themes verificar se há sobreposição entre a ActionBar e a DrawerNavigation. Definir o tema do app como NoActionBar , substituindo:

```kotlin
<style name="Theme.NavigationDrawer" parent="Theme.AppCompat.Light.DarkActionBar">
```

por 

```kotlin
<style name="Theme.NavigationDrawer" parent="Theme.MaterialComponents.DayNight.NoActionBar">
```



Em activity_main.xml acrescentar uma Toolbar:

```kotlin
<androidx.appcompat.widget.Toolbar
    android:layout_width=""
    android:layout_height=""
```

Complementar os parâmetros:

```kotlin
<androidx.appcompat.widget.Toolbar
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="?attr/actionBarSize"
    android:background="?attr/colorPrimary"
	app:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
    app:title="@string/app_name"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintEnd_toEndOf="parent"/>
```

E fixar os outros componentes (textview, recyclerview etc) em relação a toolbar:

```kotlin
app:layout_constraintTop_toBottomOf="@id/toolbar"
```

Se necessário remover

```kotlin
app:layout_constraintTop_toTopOf="parent"
```



Em MainActivity.kt , implementar e acrescentar a inicialização do drawer layout, no onCreate():

```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDrawer()
    }
```

E implementar o código para a inicialização, lembrando que nossa toolbar é da biblioteca androidx.appcompat.widget.Toolbar:

```kotlin
private fun initDrawer() {
    val drawerlayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
    val toolbar = findViewById<Toolbar>(R.id.toolbar)
    setSupportActionBar(toolbar)
}
```

E para a operacionalização de abrir e fechar o layout (Drawer_Layout):

```kotlin
private fun initDrawer() {
    val drawerlayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
    val toolbar = findViewById<Toolbar>(toolbar)
    setSupportActionBar(toolbar)

    val toggle = ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open_drawer,R.string.close_drawer)
    drawerlayout.addDrawerListener(toggle)
    toggle.syncState()
}
```

No onCreate() substituir a view 

```kotlin
setContentView(R.layout.activity_main)
```

por

```kotlin
setContentView(R.layout.drawer_menu)
```



Em java/res/values/strings.xml Acrescentar os títulos de Abrir e Fechar, para informar quando o menu está aberto ou fechado para fins de acessibilidade : 

```kotlin
<resources>
    <string name="app_name">NavigationDrawer</string>
    <string name="item_menu_1">Compartilhar</string>
    <string name="item_menu_2">Editar</string>
    <string name="item_menu_3">Excluir</string>
    <string name="item_menu_4">Buscar</string>
    <string name="item_menu_5">Ligar</string>
    <string name="item_menu_6">Favoritar</string>

    <string name="open_drawer">Abrir</string>
    <string name="close_drawer">Fechar</string>
</resources>
```

