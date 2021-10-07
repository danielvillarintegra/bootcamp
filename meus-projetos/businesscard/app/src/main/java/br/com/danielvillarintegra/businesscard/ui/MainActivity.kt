package br.com.danielvillarintegra.businesscard.ui

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
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
        val businessCard = BusinessCard(
            nome = "Daniel",
            empresa = "D Integra e Resolve",
            telefone = "11 99",
            email = "daniel@att.com",
            fundoPersonalizado = "#FFFFFFFF"
        )
        mainViewModel.insert(businessCard)
        finish()

        val businessCard2 = BusinessCard(
            nome = "bi",
            empresa = "Cra",
            telefone = "55 11 99",
            email = "bi@fmail.com",
            fundoPersonalizado = "#FFF00FFF"
        )
        mainViewModel.insert(businessCard2)
        Log.i("I/Sucesso","MainActivity Inserido mock com sucesso")
        finish()
    }

    private fun insertListeners() {
        binding.tvTitle.setOnClickListener {
            mockInicial()
        }
        binding.fab.setOnClickListener {
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            startActivity(intent)
            Log.i("I/Sucesso","Click em inserir (popupmenu->MA)")
        }

        adapter.listenerEdit = {
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            intent.putExtra("index", it.id)
            startActivity(intent)
            Log.i("I/Sucesso","Click em Edit (popupmenu->MA) $it.id")
        }

        adapter.listenerOne = {
            Log.i("I/Sucesso","Click em ListenerOne (popupmenu) ${it.nome}")
        }

        adapter.listenerDelete = {
            mainViewModel.delete(it)
            finish()
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