package com.example.appcontatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list: MutableList<Contact> = mutableListOf()

    // Essa fun cria a visualização
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent,false)
            return ContactAdapterViewHolder(view)
    }

    // Essa fun faz a manipulação dos dados - populate
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
            holder.bind(list[position])
    }

    override fun getItemCount(): Int {
            return list.size
    }

    fun updateList(list: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ContactAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private val ivPhotograph: ImageView = itemView.findViewById(R.id.iv_photograph)

        fun bind(contact: Contact) {  //Popula os dados
            tvName.text = contact.name
            tvPhone.text = contact.phone

        }
    }


}