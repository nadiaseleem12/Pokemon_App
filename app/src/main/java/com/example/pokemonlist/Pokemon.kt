package com.example.pokemonlist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon( val image:Int, val name:String, val type:String,val attack:Int,val defense:Int):Parcelable
