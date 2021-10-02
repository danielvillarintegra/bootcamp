Exemplo simplificado de uso de um seekbar

Acrescentado alteração da cor de fundo e do texto em um textView .

Em seguida os códigos originais obtidos no site:

https://www.geeksforgeeks.org/seekbar-in-kotlin/

activity_main.xml

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools"
android:id="@+id/container"
android:layout_width="match_parent"
android:layout_height="match_parent"
tools:context=".MainActivity"
android:orientation="vertical">
  
    <SeekBar
        android:id="@+id/seekBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="50dp"
        android:max="100"
        android:min="0" />
</LinearLayout>
```



MainActivity.kt

```kotlin
package com.geeksforgeeks.myfirstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val seek = findViewById<SeekBar>(R.id.seekBar)
		seek?.setOnSeekBarChangeListener(object :
			SeekBar.OnSeekBarChangeListener {
		override fun onProgressChanged(seek: SeekBar,
			progress: Int, fromUser: Boolean) {
		// write custom code for progress is changed
		}

		override fun onStartTrackingTouch(seek: SeekBar) {
			// write custom code for progress is started
		}

		override fun onStopTrackingTouch(seek: SeekBar) {
				// write custom code for progress is stopped
		Toast.makeText(this@MainActivity,
			"Progress is: " + seek.progress + "%",
				Toast.LENGTH_SHORT).show()
			}
		})
	}
}
```


AndroidManifest.xml

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
package="com.geeksforgeeks.myfirstkotlinapp">

<application
	android:allowBackup="true"
	android:icon="@mipmap/ic_launcher"
	android:label="@string/app_name"
	android:roundIcon="@mipmap/ic_launcher_round"
	android:supportsRtl="true"
	android:theme="@style/AppTheme">
	<activity android:name=".MainActivity">
		<intent-filter>
			<action android:name="android.intent.action.MAIN" />

			<category android:name="android.intent.category.LAUNCHER" />
		</intent-filter>
	</activity>
</application>

</manifest>
```
