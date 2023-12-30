package com.example.pokemonlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter(val pokemonList: List<Pokemon>?) :
    RecyclerView.Adapter<PokemonAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.card_view)
        val pokemonIV = itemView.findViewById<ImageView>(R.id.imv_pokemon_icon)
        val pokemonNameTv = itemView.findViewById<TextView>(R.id.tv_name)
        val pokemonTypeTv: TextView = itemView.findViewById(R.id.tv_type)
        val pokemonAttackTv = itemView.findViewById<TextView>(R.id.tv_attack_value)
        val pokemonDefenseTv = itemView.findViewById<TextView>(R.id.tv_defense_value)

        fun bind(pokemon: Pokemon) {
            pokemonIV.setImageResource(pokemon.image)
            pokemonNameTv.text = pokemon.name
            pokemonTypeTv.text = pokemon.type
            pokemonAttackTv.text = pokemon.attack.toString()
            pokemonDefenseTv.text = pokemon.defense.toString()
            val backgroundColor = when(pokemon.type){
                "fire"-> {
                    pokemonTypeTv.setBackgroundResource(R.drawable.fire_bg)
                    itemView.resources.getColor(R.color.red)
                }
                "grass"-> {
                    pokemonTypeTv.setBackgroundResource(R.drawable.grass_bg)
                    itemView.resources.getColor(R.color.green)
                }
                "water"-> {
                    pokemonTypeTv.setBackgroundResource(R.drawable.water_bg)
                    itemView.resources.getColor(R.color.blue)
                }
                else -> {
                    pokemonTypeTv.setBackgroundResource(R.color.black)
                    itemView.resources.getColor(R.color.white)}
            }
            cardView.setCardBackgroundColor(backgroundColor)



        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = pokemonList?.size ?: 0


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pokemon = pokemonList!![position]
        holder.bind(pokemon)
        if(onPokemonClickListner!=null) {
            holder.itemView.setOnClickListener {
                onPokemonClickListner?.onPokemonClick(pokemon)
            }
        }
    }

    var onPokemonClickListner:OnPokemonClickListner?=null

     fun interface OnPokemonClickListner{
        fun onPokemonClick(pokemon: Pokemon)
    }
}