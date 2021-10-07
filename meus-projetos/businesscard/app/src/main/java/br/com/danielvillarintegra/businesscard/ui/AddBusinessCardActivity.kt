package br.com.danielvillarintegra.businesscard.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.danielvillarintegra.businesscard.App
import br.com.danielvillarintegra.businesscard.data.BusinessCard
import br.com.danielvillarintegra.businesscard.databinding.ActivityAddBusinessCardBinding
import com.google.android.material.slider.Slider
import kotlin.math.roundToInt

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        insertListeners()
//        setupContato()

        binding.slideColor.setLabelFormatter { value: Float ->
            return@setLabelFormatter "${value.roundToInt()}"
        }
    }

/*        private fun setupContato() {
            val idContato : Int = intent.getIntExtra("index", -1)
            Log.i("I/Sucesso idContato = ","$idContato em setupContato()")

            //binding.pbProgressbar.visibility = View.VISIBLE

            if (idContato == -1) {
                binding.tvTitle.text = "Novo cartão"
                binding.btnConfirm.text = "Inserir"
                Log.i("I/Sucesso","AddBusinessCard - Novo cartão")
            } else {
                binding.tvTitle.text = "Alterar cartão"
                binding.btnConfirm.text = "Alterar"
                Log.i("I/Sucesso","AddBusinessCard - Alterar cartão")
            }
            //binding.pbProgressbar.visibility = View.GONE
        }


 */

    private fun insertListeners() {
        binding.btnConfirm.setOnClickListener {
            val idContato : Int = intent.getIntExtra("index", -1)
            Log.i("I/Sucesso idContato = ","$idContato em setOnClickListener()")

            binding.pbProgressbar.visibility = View.VISIBLE // "Mostra" a ProgressBar

            if (idContato == -1) {
                val businessCard = BusinessCard(
                    nome = binding.tilNome.editText?.text.toString(),
                    empresa = binding.tilEmpresa.editText?.text.toString(),
                    telefone = binding.tilTelefone.editText?.text.toString(),
                    email = binding.tilEmail.editText?.text.toString(),
                    fundoPersonalizado = binding.tilCor.editText?.text.toString().uppercase()
                    //fundoPersonalizado = binding.layoutAddBusinessCard.background.colorFilter.toString()
                )
                mainViewModel.insert(businessCard)
                Log.i("I/Sucesso","Inserido com sucesso")
            } else {
                val businessCard = BusinessCard(
                    //id = idContato,
                    nome = binding.tilNome.editText?.text.toString(),
                    empresa = binding.tilEmpresa.editText?.text.toString(),
                    telefone = binding.tilTelefone.editText?.text.toString(),
                    email = binding.tilEmail.editText?.text.toString(),
                    fundoPersonalizado = binding.tilCor.editText?.text.toString().uppercase()
                    //fundoPersonalizado = binding.layoutAddBusinessCard.background.colorFilter.toString()
                )
                mainViewModel.update(businessCard)
                Log.d( "I/Sucesso","Atualizado com sucesso")
            }

            //
            // TODO se (id < 0) fazer tratamento de erros com mensagem "falha ao inserir dados"
            //

            binding.pbProgressbar.visibility = View.GONE // "Esconde" a ProgressBar
            finish()
        }

        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.slideColor.addOnChangeListener(object : Slider.OnChangeListener {
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {

                val corFundo = escolherCor(value.roundToInt())
                binding.tilCor.setBackgroundColor(Color.parseColor(corFundo))
                binding.tilCor.editText?.setText(corFundo)
                binding.layoutAddBusinessCard.setBackgroundColor(Color.parseColor(corFundo))

                //Toast.makeText( "cor de fundo ${binding.layoutAddBusinessCard.background}", Toast.LENGTH_SHORT).show()

            }
        })
    }

    private fun escolherCor(progress : Int) : String {
        val corFundo: String

        corFundo = when (progress) {
            0 -> "#FFFFFFFF"  //"@colors/white"
            1 -> "#FFF44334"  //"@colors/red_500"
            2 -> "#FFFF9800"  //"@colors/orange_500"
            3 -> "#FFFFEB3B"  //"@colors/yellow_500"
            4 -> "#FF4CAF50"  //"@colors/green_500"
            5 -> "#FF2196F3"  //"@colors/blue_500"
            6 -> "#FF6200EE"  //"@colors/purple_500"
            7 -> {
                "#FF000000" //"@colors/black"
                //      corTexto = "#FFFFFFFF"   //"@colors/white"
            }
            else -> "#FFFFFFFF"   //"@colors/white"
        }
        return corFundo
    }

}
