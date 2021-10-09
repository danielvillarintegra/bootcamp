package br.com.danielvillarintegra.businesscard.ui

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import br.com.danielvillarintegra.businesscard.App
import br.com.danielvillarintegra.businesscard.data.BusinessCard
import br.com.danielvillarintegra.businesscard.databinding.ActivityMainBinding
import br.com.danielvillarintegra.businesscard.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpPermissions()
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListeners()
    }

    private fun setUpPermissions() {
        // write permission to access the storage
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
            1
        )
        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            1
        )
    }

    private fun mockInicial() {
        var businessCard = BusinessCard(
            nome = "José Maria João",
            empresa = "Panificadora da esquina",
            telefone = "2345-9999",
            email = "josemariajoao@panific.com.br",
            fundoPersonalizado = "#FFFFFF90"
        )
        mainViewModel.insert(businessCard)

        businessCard = BusinessCard(
            nome = "Maria José Antonio",
            empresa = "Boutique do bairro",
            telefone = "2345-1285",
            email = "mariajoseantonio@butiqchic.com",
            fundoPersonalizado = "#FFF00FFF"
        )
        mainViewModel.insert(businessCard)
        Log.i("I/Sucesso","MainActivity Inserido mock com sucesso")
    }

    private fun insertListeners() {
        binding.tvTitle.setOnClickListener {
            binding.pbProgressbar.visibility = View.VISIBLE  // Torna visível a ProgressBar
            Thread {

                try {
                    mockInicial()
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
                runOnUiThread {
                    binding.pbProgressbar.visibility = View.GONE // "Esconde" a ProgressBar
                    Toast.makeText(this, "Populando", Toast.LENGTH_SHORT).show()
                }
            }.start()
        }

        binding.fab.setOnClickListener {
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            startActivity(intent)
            Log.i("I/Sucesso","Click em inserir (popupmenu->MA)")
        }

        adapter.listenerEdit = { businessCard ->
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            intent.putExtra("index", businessCard.id)
            intent.putExtra("nome", businessCard.nome)
            intent.putExtra("telefone", businessCard.telefone)
            intent.putExtra("email", businessCard.email)
            intent.putExtra("empresa", businessCard.empresa)
            intent.putExtra("fundoPersonalizado", businessCard.fundoPersonalizado)
            startActivity(intent)
            Log.i("I/Sucesso","Click em Edit (popupmenu->MA) $businessCard.id")
        }

        adapter.listenerDelete = { businessCard ->
            binding.pbProgressbar.visibility = View.VISIBLE  // Torna visível a ProgressBar
            Thread {
                try {
                    mainViewModel.delete(businessCard)
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
                runOnUiThread {
                    binding.pbProgressbar.visibility = View.GONE // "Esconde" a ProgressBar
                    Toast.makeText(this, "Apagado ${businessCard.nome}",
                        Toast.LENGTH_SHORT).show()
                }
            }.start()
        }

        adapter.listenerShare = { card ->
            Image.share(this@MainActivity, card)
        }
        getAllBusinessCard()
    }


    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this, { businessCards ->
            adapter.submitList(businessCards)
        })
    }
}