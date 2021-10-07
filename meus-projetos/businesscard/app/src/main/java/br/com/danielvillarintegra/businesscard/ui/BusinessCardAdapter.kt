package br.com.danielvillarintegra.businesscard.ui


import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.danielvillarintegra.businesscard.R
import br.com.danielvillarintegra.businesscard.data.BusinessCard
import br.com.danielvillarintegra.businesscard.databinding.ItemBusinessCardBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerEdit: (BusinessCard) -> Unit = {}
    var listenerDelete: (BusinessCard) -> Unit = {}
    var listenerOne: (BusinessCard) -> Unit = {}
    var listenerShare: (View) -> Unit = {}
    private var currentBusinessCard: BusinessCard? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(businessCard: BusinessCard) {
            binding.tvId.text = businessCard.id.toString()
            binding.tvNome.text = businessCard.nome
            binding.tvTelefone.text = businessCard.telefone
            binding.tvEmail.text = businessCard.email
            binding.tvNomeEmpresa.text = businessCard.empresa
            binding.cdContent.setCardBackgroundColor(Color.parseColor(businessCard.fundoPersonalizado))

            binding.ivMore.setOnClickListener {
                currentBusinessCard?.let {
                    Log.i("I/Sucesso","Let ${it.id}")

                }
                showPopup(businessCard)
                Log.i("I/Sucesso","View ${ it.id}")
            }

        }

        private fun showPopup(businessCard: BusinessCard) {
            val ivMore = binding.ivMore
            val popupMenu = PopupMenu(ivMore.context, ivMore)
            popupMenu.menuInflater.inflate(R.menu.popup_menu, popupMenu.menu)
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_share -> listenerShare(itemView)
                    R.id.action_edit -> listenerEdit(businessCard)
                    R.id.action_one -> listenerOne(businessCard)
                    R.id.action_delete -> listenerDelete(businessCard)
                }

                return@setOnMenuItemClickListener true
            }
            popupMenu.show()
        }

    }

}

class DiffCallback : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean {
        return oldItem.id == newItem.id
    }
}