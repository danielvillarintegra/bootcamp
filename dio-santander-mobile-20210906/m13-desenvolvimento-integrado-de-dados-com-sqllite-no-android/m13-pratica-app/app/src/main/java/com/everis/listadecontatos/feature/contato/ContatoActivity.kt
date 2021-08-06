package com.everis.listadecontatos.feature.contato

import android.os.Bundle
import android.view.View
import com.everis.listadecontatos.R
import com.everis.listadecontatos.application.ContatoApplication
import com.everis.listadecontatos.bases.BaseActivity
import com.everis.listadecontatos.feature.listacontatos.model.ContatosVO
import kotlinx.android.synthetic.main.activity_contato.*
import kotlinx.android.synthetic.main.activity_contato.progress
import kotlinx.android.synthetic.main.activity_contato.toolBar
import kotlinx.android.synthetic.main.activity_main.*

class ContatoActivity : BaseActivity() {

    private var idContato: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato)
        setupToolBar(toolBar, "Contato", true)
        setupContato()
        btnSalvarConato.setOnClickListener { onClickSalvarContato() }
    }

    private fun setupContato() {

        idContato = intent.getIntExtra("index", -1)
        if (idContato == -1) {
            btnExcluirContato.visibility = View.GONE
            return
        }
        progress.visibility = View.VISIBLE
        Thread {

            var lista = ContatoApplication.instance.helperDB?.buscarContatos("$idContato", true)
                ?: return@Thread
            var contato = lista?.getOrNull(0) ?: return@Thread

            runOnUiThread {
                etNome.setText(contato.nome)
                etTelefone.setText(contato.telefone)
                progress.visibility = View.GONE // "Esconde" a ProgressBar
            }

        }.start()

    }

    private fun onClickSalvarContato() {
        progress.visibility = View.VISIBLE  // Torna visível a ProgressBar

        val nome = etNome.text.toString()
        val telefone = etTelefone.text.toString()
        val contato = ContatosVO(
            idContato,
            nome,
            telefone
        )

        Thread {
            if (idContato == -1) {
                ContatoApplication.instance.helperDB?.salvarContato(contato)
            } else {
                ContatoApplication.instance.helperDB?.updateContato(contato)
            }
            runOnUiThread {
                progress.visibility = View.GONE // "Esconde" a ProgressBar
                finish()
            }
        }.start()
    }

    fun onClickExcluirContato(view: View) {
        if (idContato > -1) {
            progress.visibility = View.VISIBLE  // Torna visível a ProgressBar
            Thread {

                ContatoApplication.instance.helperDB?.deletarContato(idContato)
                runOnUiThread {
                    progress.visibility = View.GONE // "Esconde" a ProgressBar
                    finish()
                }
            }.start()
        }
    }
}
