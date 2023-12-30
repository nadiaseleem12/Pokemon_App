package com.example.pokemonlist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val pokemonList:MutableList<Pokemon> = mutableListOf()
    private lateinit var pokemonAdapter: PokemonAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()


    }

    private fun initRecyclerView() {
        createPokemonList()
        pokemonAdapter = PokemonAdapter(pokemonList)


        pokemonAdapter.onPokemonClickListner = PokemonAdapter.OnPokemonClickListner { pokemon->
            navigateToPokemonDetailsActivity(pokemon)
        }

        binding.rvPokemonList.adapter = pokemonAdapter
    }

    private fun navigateToPokemonDetailsActivity(pokemon:Pokemon) {
        val intent = Intent(this,PokemonDetailsActivity::class.java)
        intent.putExtra("pokemon",pokemon)
        startActivity(intent)
    }

    private fun createPokemonList() {
        for (i in 100 downTo 1 step 2 ){
            pokemonList.add(Pokemon(R.drawable.bulbasaur,"Bulbasaur", type = "grass",65,65))
            pokemonList.add(Pokemon(R.drawable.venusaur,"Venusaur", type = "grass",122,120))
            pokemonList.add(Pokemon(R.drawable.ivysaur,"Ivysaur", type = "grass",80,80))
            pokemonList.add(Pokemon(R.drawable.charmander,"Charmander", type = "fire",60,50))
            pokemonList.add(Pokemon(R.drawable.charmeleon,"Charmeleon", type = "fire",80,65))
            pokemonList.add(Pokemon(R.drawable.charizard,"Charizard", type = "fire",159,115))
            pokemonList.add(Pokemon(R.drawable.squirtle,"Squirtle", type = "water",50,64))
            pokemonList.add(Pokemon(R.drawable.wartortle,"Wartortle", type = "water",65,80))
            pokemonList.add(Pokemon(R.drawable.blastoise,"Charizard", type = "water",135,115))

        }

    }
}