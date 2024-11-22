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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.outlined.FastForward
import androidx.compose.material.icons.outlined.FastRewind
import androidx.compose.material.icons.outlined.Pause
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrh.reproductor.ui.theme.ReproductorTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReproductorTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Reproductor DAM")
                            },
                            actions = {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.List,
                                    contentDescription = null
                                )
                            }
                        )
                    },
                    bottomBar = {
                        MusicBottomBar()
                    }
                ) { innerPadding ->
                    AlbumView(
                        Album(
                            artista = "Profe",
                            canciones = listOf(),
                            nombre = "Album",
                            cover = R.raw.cover,
                            genre = Generos.TRAP.nombre
                        ),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    @SuppressLint("ResourceType")
    @Composable
    fun MusicBottomBar() {
        val values = listOf(NavBarValues.INICIO, NavBarValues.PLAYLISTS)
        var isPlaying by remember { mutableStateOf(false) }
        Card {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(start = 12.dp)
                ) {
                    Image(
                        painter = painterResource(R.raw.cover),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Column {
                        Text("Nombre de la cancion", fontWeight = FontWeight.Bold)
                        Text("Artista")
                    }
                }
                Row() {
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(imageVector = Icons.Outlined.FastRewind, contentDescription = null)
                    }
                    IconButton(
                        onClick = {
                            isPlaying = !isPlaying
                        },
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondary,
                            contentColor = MaterialTheme.colorScheme.onSecondary
                        )
                    ) {
                        if (isPlaying) {
                            Icon(imageVector = Icons.Outlined.Pause, contentDescription = null)
                        } else {
                            Icon(imageVector = Icons.Outlined.PlayArrow, contentDescription = null)
                        }

                    }
                    IconButton(
                        onClick = {

                        }
                    ) {
                        Icon(imageVector = Icons.Outlined.FastForward, contentDescription = null)
                    }
                }
            }
            NavigationBar(
                containerColor = Color.Transparent
            ) {
                values.forEach { valor ->
                    NavigationBarItem(
                        icon = {
                            Icon(imageVector = valor.icon!!, contentDescription = null)
                        },
                        onClick = {

                        },
                        selected = true,
                        label = {
                            Text(valor.label!!)
                        }
                    )
                }
            }
        }
    }

    @SuppressLint("ResourceType")
    @Composable
    fun HomeView(modifier: Modifier = Modifier) {
        val lista = listOf(
            Album(
                artista = "Profe",
                canciones = listOf(),
                nombre = "Albumasdfghyuiouykjhrtgefw",
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
                items(lista.filter { album ->
                    if (selectedGenres.isEmpty()) {
                        true
                    } else {
                        album.genre in selectedGenres
                    }
                }) { elemento ->
                    AlbumCard(elemento)
                }
            }
        }
    }

    @Composable
    fun AlbumView(album: Album, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(album.cover),
                contentDescription = null,
                modifier = Modifier.size(230.dp).clip(RoundedCornerShape(20.dp))
            )
            Text(text = album.nombre, fontSize = 35.sp)
            Text(text = album.artista , fontSize = 20.sp)
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
            Text(
                album.nombre,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(album.artista)
        }
    }
}

