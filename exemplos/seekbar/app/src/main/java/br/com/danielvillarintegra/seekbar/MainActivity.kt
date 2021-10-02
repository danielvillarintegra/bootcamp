package br.com.danielvillarintegra.seekbar

import android.graphics.Color
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
                alteraCor(progress)
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
        val tvColor = findViewById<TextView>(R.id.tv_cor)

        tvColor.text = corTexto
        tvColor.setTextColor(Color.parseColor(corTexto))
        tvColor.setBackgroundColor(Color.parseColor(corFundo))

    }

}