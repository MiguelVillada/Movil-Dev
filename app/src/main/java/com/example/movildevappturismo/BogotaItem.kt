package com.example.movildevappturismo


import com.google.gson.annotations.SerializedName

data class BogotaItem(
    @SerializedName("descripCorta")
    val descripCorta: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("urlpic")
    val urlpic: String
)