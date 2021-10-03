package br.com.danielvillarintegra.slider

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val slContinuousSlider = findViewById<Slider>(R.id.sl_continuous_slider)

        slContinuousSlider.setLabelFormatter { value: Float ->
            return@setLabelFormatter "$${value.roundToInt()}"
        }


        slContinuousSlider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being started
                Log.d("onStartTrackingTouch", slider.value.toString())
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being stopped
                Log.d("onStopTrackingTouch", slider.value.toString())
            }
        })
/* "lambda do código abaixo"
        slContinuousSlider.addOnChangeListener(Slider.OnChangeListener { slider, value, fromUser ->
            Log.d("addOnChangeListener", slider.value.toString())
            alteraCor(value.roundToInt())
        }
*/
        slContinuousSlider.addOnChangeListener(object: Slider.OnChangeListener{
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                Log.d("addOnChangeListener", slider.value.toString())
                alteraCor(value.roundToInt())
            }
        })



    }
    private fun alteraCor(progress : Int){
        var corFundo: String
        var corTexto: String

        corTexto = "#FF000000"  //"@colors/black"
        when (progress) {
            0 -> corFundo = "#FFFFFFFF"  //"@colors/white"
            1 -> corFundo = "#FFF44334"  //"@colors/red_500"
            2 -> corFundo = "#FFFF9800"  //"@colors/orange_500"
            3 -> corFundo = "#FFFFEB3B"  //"@colors/yellow_500"
            4 -> corFundo = "#FF4CAF50"  //"@colors/green_500"
            5 -> corFundo = "#FF2196F3"  //"@colors/blue_500"
            6 -> corFundo = "#FF6200EE"  //"@colors/purple_500"
            7 -> {
                corFundo = "#FF000000" //"@colors/black"
                corTexto = "#FFFFFFFF"   //"@colors/white"
            }
            else -> corFundo = "#FFFFFFFF"   //"@colors/white"
        }
        val tvColor = findViewById<TextView>(R.id.tv_continuous_slider)

        tvColor.text = corTexto
        tvColor.setTextColor(Color.parseColor(corTexto))
        tvColor.setBackgroundColor(Color.parseColor(corFundo))

    }
}