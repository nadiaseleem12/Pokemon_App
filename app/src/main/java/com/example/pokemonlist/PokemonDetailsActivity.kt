package com.example.pokemonlist

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonlist.databinding.ActivityPokemonDetailsBinding

class PokemonDetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivityPokemonDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pokemon = intent.parcelable<Pokemon>("pokemon")
        pokemon?.let{  pokemon ->
           binding.imvIcon.setImageResource(pokemon.image)
        }

    }
}
inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
    SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
    else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
}
