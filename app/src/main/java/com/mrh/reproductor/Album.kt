package com.mrh.reproductor

data class Album(
    val nombre: String,
    val artista: String,
    val cover: Int,
    val canciones: List<Song>,
    val genre: String
)
