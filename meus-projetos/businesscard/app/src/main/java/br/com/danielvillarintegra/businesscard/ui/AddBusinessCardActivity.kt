package br.com.danielvillarintegra.businesscard.ui

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.danielvillarintegra.businesscard.App
import br.com.danielvillarintegra.businesscard.R
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
        setupContato()

        binding.slideColor.setLabelFormatter { value: Float ->
            return@setLabelFormatter "${value.roundToInt()}"
        }
    }

    private fun setupContato() {
        val idContato : Int = intent.getIntExtra("index", -1)
        val nome : String = intent.extras?.getString("nome") ?: "digite novamente o nome"
        val telefone : String = intent.extras?.getString("telefone") ?: "digite novamente o telefone"
        val email : String = intent.extras?.getString("email") ?: "digite novamente o email"
        val empresa : String = intent.extras?.getString("empresa") ?: "digite novamente a empresa"
        val fundoPersonalizado : String = intent.extras?.getString("fundoPesonalizado") ?: "#FFFFFFFF"

        Log.i("I/Sucesso idContato = ","$idContato em setupContato()")
        if (idContato == -1) {
            binding.tvTitle.text = getString(R.string.label_description_new_card)
            //binding.layoutAddBusinessCard.setBackgroundColor(Color.parseColor("write"))
            Log.i("I/Sucesso","AddBusinessCard - Novo cartão")
        } else {
            binding.pbProgressbar.visibility = View.VISIBLE
            try {
                    binding.tvTitle.text = getString(R.string.label_description_change_card)
                    binding.tilNome.editText?.setText(nome)
                    binding.tilTelefone.editText?.setText(telefone)
                    binding.tilEmail.editText?.setText(email)
                    binding.tilEmpresa.editText?.setText(empresa)
                    binding.tilCor.editText?.setText(fundoPersonalizado)
                    //binding.layoutAddBusinessCard.setBackgroundColor(Color.parseColor("blue"))
                  Log.i("I/Sucesso","dados para alteração preenchidos com sucesso")
                } catch (ex: Exception) {
                    ex.printStackTrace()
                    Log.e("E/Erro","erro ao preencher dados para alterar AddBusinessCard")
                }
            binding.pbProgressbar.visibility = View.GONE // "Esconde" a ProgressBar
            Log.i("I/Sucesso","AddBusinessCard - Alterar cartão")
        }
    }

    private fun insertListeners() {
        binding.btnConfirm.setOnClickListener {
            binding.pbProgressbar.visibility = View.VISIBLE // "Mostra" a ProgressBar
            val idContato: Int = intent.getIntExtra("index", -1)
            if (idContato <= 0) {
                Thread {
                    try {
                        val corFundo : String = binding.tilCor.editText?.text.toString().uppercase()
                        val businessCard = BusinessCard(
                            nome = binding.tilNome.editText?.text.toString(),
                            empresa = binding.tilEmpresa.editText?.text.toString(),
                            telefone = binding.tilTelefone.editText?.text.toString(),
                            email = binding.tilEmail.editText?.text.toString(),
                            fundoPersonalizado = corFundo
                            //fundoPersonalizado = binding.layoutAddBusinessCard.background.toString().uppercase()
                        )
                        mainViewModel.insert(businessCard)
                        Log.i("I/Sucesso","Inserido com sucesso")
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                        Log.e("E/Erro","erro ao inserir dados AddBusinessCard")
                    }
                    runOnUiThread {
                        binding.pbProgressbar.visibility = View.GONE // "Esconde" a ProgressBar
                    }
                }.start()
            } else {
                Thread {
                    try {
                        val corFundo : String = binding.tilCor.editText?.text.toString().uppercase()
                        val businessCard = BusinessCard(
                            id = idContato,
                            nome = binding.tilNome.editText?.text.toString(),
                            empresa = binding.tilEmpresa.editText?.text.toString(),
                            telefone = binding.tilTelefone.editText?.text.toString(),
                            email = binding.tilEmail.editText?.text.toString(),
                            fundoPersonalizado = corFundo
                            //fundoPersonalizado = binding.tilCor.editText?.text.toString()
                            //fundoPersonalizado = binding.layoutAddBusinessCard.background.toString().uppercase()
                        )
                        mainViewModel.update(businessCard)
                        Log.i( "I/Sucesso","Atualizado com sucesso")

                    } catch (ex: Exception) {
                        ex.printStackTrace()
                        Log.e("E/Erro","erro ao alterar dados AddBusinessCard")
                    }
                    runOnUiThread {
                        binding.pbProgressbar.visibility = View.GONE // "Esconde" a ProgressBar
                    }
                }.start()
            }


            //
            // TODO se (id < 0) fazer tratamento de erros com mensagem "falha ao inserir dados"
            //
            finish()
        }

        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.slideColor.addOnChangeListener(object : Slider.OnChangeListener {
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                val corFundo = escolherCor(value.roundToInt())
                try {
                    binding.tilCor.setBackgroundColor(Color.parseColor(corFundo.uppercase()))
                    binding.tilCor.editText?.setText(corFundo.uppercase())
                } catch (ex: Exception) {
                        ex.printStackTrace()
                        Log.e("E/Erro","erro ao alterar cor slider, AddBusinessCard")
                }

            }
        })
    }

    private fun escolherCor(progress : Int): String {
        val corFundo = when (progress) {
            0 -> "#FFBB86FC"  //R.color.purple_200
            1 -> "#FFF44334"  //R.color.red_500
            2 -> "#FFFF9800"  //R.color.orange_500
            3 -> "#FFFFEB3B"  //R.color.yellow_500
            4 -> "#FF4CAF50"  //R.color.green_500
            5 -> "#FF2196F3"  //R.color.blue_500
            6 -> "#FF6200EE"  //R.color.purple_500
            7 -> "#FF3700B3"  // R.color.purple_700
            //Se usar cor de fundo preta "#FF000000" //"@colors/black"
            //alterar a cor do Texto para branca ou amarela "#FFFFFFFF"   //"@colors/white"

            else -> "#FFFFFFFF"    // R.color.white
        }

        return corFundo
    }

}
