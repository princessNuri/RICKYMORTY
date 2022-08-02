package com.example.rickymorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickymorty.databinding.ItemCharactersBinding

class MainAdapter(
    private val data: ArrayList<com.example.rickymorty.Character>,
    private var onClick: onClick
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {


    fun setOnClick(onClick: onClick){
        this.onClick = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding: ItemCharactersBinding =
            ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class MainViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(character: com.example.rickymorty.Character) {
            binding.tvName.text = character.name
            binding.tvLife.text = character.life
            binding.ivPicture.loadWithGlide(character.picture)
            binding.root.setOnClickListener(){
                onClick.onClick(character)
            }
        }

    }

}
