Exemplo simplificado de uso de um slider discreto

Acrescentado alteração da cor de fundo e do texto em um textView .

Em seguida os códigos originais obtidos no site:

https://github.com/velmurugan-murugesan/Android-Example/blob/master/SliderMaterialDesign/app/src/main/res/values/styles.xml

Referências: 

https://material.io/components/sliders/android#discrete-slider



activity_main.xml

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <androidx.appcompat.widget.AppCompatTextView
        android:id="@+id/textContinuousSlider"
        android:text="Continuous Slider"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:gravity="center"
        style="@style/TextAppearance.MaterialComponents.Body1"
        android:layout_margin="40dp"/>

    <com.google.android.material.slider.Slider
        android:id="@+id/continuousSlider"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@+id/textContinuousSlider"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_margin="10dp"
        android:valueFrom="0.0"
        android:valueTo="100.0"
        android:value="20.0"
        app:labelBehavior="floating"
        />

    <androidx.appcompat.widget.AppCompatTextView
        android:id="@+id/textDiscreteSlider"
        android:text="Discrete Slider"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@+id/continuousSlider"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:gravity="center"
        style="@style/TextAppearance.MaterialComponents.Body1"
        android:layout_margin="40dp"/>

    <com.google.android.material.slider.Slider
        android:id="@+id/discreteSlider"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@+id/textDiscreteSlider"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_margin="10dp"
        android:valueFrom="0.0"
        android:valueTo="100.0"
        android:stepSize="10.0"
        app:labelBehavior="withinBounds"
        android:value="30.0"
        />

    <androidx.appcompat.widget.AppCompatTextView
        android:id="@+id/textRangeSlider"
        android:text="Range Slider"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@+id/discreteSlider"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:gravity="center"
        style="@style/TextAppearance.MaterialComponents.Body1"
        android:layout_margin="40dp"/>

    <com.google.android.material.slider.RangeSlider
        android:id="@+id/rangeSlider"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintTop_toBottomOf="@+id/textRangeSlider"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        android:layout_margin="10dp"
        android:valueFrom="0.0"
        android:valueTo="100.0"
        app:values="@array/initial_range_slider_values"
        />



</androidx.constraintlayout.widget.ConstraintLayout>
```



MainActivity.kt

```kotlin
package com.example.slidermaterialdesign

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        continuousSlider.setLabelFormatter { value: Float ->
            return@setLabelFormatter "$${value.roundToInt()}"
        }


        continuousSlider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being started
                Log.d("onStartTrackingTouch", slider.value.toString())
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being stopped
                Log.d("onStopTrackingTouch", slider.value.toString())
            }
        })

        continuousSlider.addOnChangeListener(object: Slider.OnChangeListener{
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                Log.d("addOnChangeListener", slider.value.toString())
            }
        })



        rangeSlider.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener{
            override fun onStartTrackingTouch(slider: RangeSlider) {
                val values = rangeSlider.values
                Log.d("onStartTrackingTouch From", values[0].toString())
                Log.d("onStartTrackingTouch T0", values[1].toString())
            }

            override fun onStopTrackingTouch(slider: RangeSlider) {
                val values = rangeSlider.values
                Log.d("onStopTrackingTouch From", values[0].toString())
                Log.d("onStopTrackingTouch T0", values[1].toString())
            }
        })


        rangeSlider.addOnChangeListener(object : RangeSlider.OnChangeListener{

            override fun onValueChange(slider: RangeSlider, value: Float, fromUser: Boolean) {
                val values = rangeSlider.values
                Log.d("From", values[0].toString())
                Log.d("T0", values[1].toString())
            }
        })

        rangeSlider.addOnChangeListener { rangeSlider, value, fromUser ->

            val values = rangeSlider.values

        }
    }
}
```



AndroidManifest.xml

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.slidermaterialdesign">

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

No projeto haviam modificações no res/values

arrays.xml

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <array name="initial_range_slider_values">
        <item>20.0</item>
        <item>80.0</item>
    </array>
</resources>
```

colors.xml

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="colorPrimary">#6200EE</color>
    <color name="colorPrimaryDark">#3700B3</color>
    <color name="colorAccent">#03DAC5</color>
    
    
    <color name="green_200">#AED581</color>
    <color name="green_900">#33691E</color>
</resources>
```


strings.xml

```kotlin
<resources>
    <string name="app_name">Slider Material Design</string>
</resources>
```



styles.xml

    <style name="Widget.App.Slider" parent="Widget.MaterialComponents.Slider">
        <item name="materialThemeOverlay">@style/ThemeOverlay.App.Slider</item>
        <item name="labelStyle">@style/Widget.App.Tooltip</item>
    </style>
    
    <style name="ThemeOverlay.App.Slider" parent="">
        <item name="colorPrimary">@color/green_200</item>
        <item name="colorOnPrimary">@color/green_900</item>
        <item name="colorOnSurface">@color/green_200</item>
    </style>


```kotlin
<resources>
    <style name="AppTheme" parent="Theme.MaterialComponents.Light.DarkActionBar">
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
        <item name="sliderStyle">@style/Widget.App.Slider</item>
    </style>

    <style name="Widget.App.Slider" parent="Widget.MaterialComponents.Slider">
        <item name="materialThemeOverlay">@style/ThemeOverlay.App.Slider</item>
        <item name="labelStyle">@style/Widget.App.Tooltip</item>
    </style>

    <style name="ThemeOverlay.App.Slider" parent="">
        <item name="colorPrimary">@color/green_200</item>
        <item name="colorOnPrimary">@color/green_900</item>
        <item name="colorOnSurface">@color/green_200</item>
    </style>


    <style name="Widget.App.Tooltip" parent="Widget.MaterialComponents.Tooltip">
        <item name="android:textAppearance">@style/TextAppearance.App.Tooltip</item>
        <item name="backgroundTint">@color/green_200</item>
    </style>

    <style name="TextAppearance.App.Tooltip" parent="TextAppearance.MaterialComponents.Tooltip">
        <item name="android:textColor">@android:color/black</item>
    </style>


</resources>
```





