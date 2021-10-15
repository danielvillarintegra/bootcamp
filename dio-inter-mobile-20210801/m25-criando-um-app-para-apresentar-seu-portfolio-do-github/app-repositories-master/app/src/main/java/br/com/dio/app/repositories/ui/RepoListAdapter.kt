package br.com.dio.app.repositories.ui

import android.graphics.Color.parseColor
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.app.repositories.data.model.Repo
import br.com.dio.app.repositories.databinding.ItemRepoBinding
import com.bumptech.glide.Glide

class RepoListAdapter : ListAdapter<Repo, RepoListAdapter.ViewHolder>(DiffCallback()) {

    var listenerOpen: (Repo) -> Unit = {}
    var languageColor : String = "FFFFFF"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Repo) {
            binding.tvRepoName.text = item.name
            binding.tvRepoDescription.text = item.description
            binding.tvRepoLanguage.text = item.language
            binding.tvRepoLanguage.setBackgroundColor(parseColor(languageColor(item.language).uppercase()))

            binding.chipStar.text = item.stargazersCount.toString()

            Glide.with(binding.root.context)
                .load(item.owner.avatarURL).into(binding.ivOwner)

            binding.ivReadMore.setOnClickListener {
                listenerOpen(item)
                Log.d("D/Sucesso","Click em ReadMore (RepoListAdapter) $item")
            }
        }

    }

/* Origem das cores
https://github.com/github/linguist/blob/master/lib/linguist/languages.yml
*/
    private fun languageColor(repoLanguage: String) : String {
        var cor : String
        when (repoLanguage) {
            "java" -> cor = "#b07219" // "#2A6277"
            "kotlin" -> cor = "#A97BFF" //"#A97BFF"
            "html" -> cor = "#e34c26" //
            "css" -> cor = "#563d7c"
            "javascript" -> cor = "#f1e05a"
            else -> cor = "#b07219"
        }
        return cor
    }

}


class DiffCallback : DiffUtil.ItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Repo, newItem: Repo) = oldItem.id == newItem.id
}