package com.mrh.reproductor

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mrh.reproductor.ui.theme.ReproductorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReproductorTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        MusicBottomBar()
                    }
                ) { innerPadding ->
                    HomeView(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @Composable
    fun MusicBottomBar() {
        NavigationBar {

        }
    }

    @SuppressLint("ResourceType")
    @Composable
    fun HomeView(modifier: Modifier = Modifier) {
        val lista = listOf(
            Album(
                artista = "Profe",
                canciones = listOf(),
                nombre = "Album",
                cover = R.raw.cover,
                genre = Generos.POP.nombre
            ), Album(
                artista = "Profe",
                canciones = listOf(),
                nombre = "Album",
                cover = R.raw.cover,
                genre = Generos.TRAP.nombre
            ), Album(
                artista = "Profe",
                canciones = listOf(),
                nombre = "Album",
                cover = R.raw.cover,
                genre = Generos.ROCK.nombre
            ), Album(
                artista = "Profe",
                canciones = listOf(),
                nombre = "Album",
                cover = R.raw.cover,
                genre = Generos.ELECTRONICA.nombre
            ), Album(
                artista = "Profe",
                canciones = listOf(),
                nombre = "Album",
                cover = R.raw.cover,
                genre = "Pop"
            ), Album(
                artista = "Profe",
                canciones = listOf(),
                nombre = "Album",
                cover = R.raw.cover,
                genre = "Pop"
            )
        )
        var selectedGenres by remember { mutableStateOf(setOf<String>()) }
        val generos = Generos.entries.map { genero -> genero.nombre }

        Column(
            modifier = modifier.fillMaxSize(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                generos.forEach { genero ->
                    FilterChip(
                        label = {
                            Text(genero)
                        },
                        onClick = {
                            selectedGenres = if (genero in selectedGenres) {
                                selectedGenres - genero
                            } else {
                                selectedGenres + genero
                            }
                        },
                        selected = genero in selectedGenres
                    )
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                horizontalArrangement = Arrangement.spacedBy(14.dp)

            ) {
                items(lista.filter { album -> if(selectedGenres.isEmpty()){ true } else{ album.genre in selectedGenres} }) { elemento ->
                    AlbumCard(elemento)
                }
            }
        }
    }

    @Composable
    fun AlbumCard(album: Album) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent,
            )
        ) {
            Image(
                painter = painterResource(album.cover),
                contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )
            Text("Album", fontWeight = FontWeight.Bold)
            Text("Artista")
        }
    }
}

