package com.mrh.reproductor

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrh.reproductor.ui.theme.ReproductorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReproductorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeView(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
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
            nombre = "Album",
            cover = R.raw.cover,
            genre = "Pop"
        ),Album(
            artista = "Profe",
            canciones = listOf(),
            nombre = "Album",
            cover = R.raw.cover,
            genre = "Pop"
        )
        ,Album(
            artista = "Profe",
            canciones = listOf(),
            nombre = "Album",
            cover = R.raw.cover,
            genre = "Pop"
        )
        ,Album(
            artista = "Profe",
            canciones = listOf(),
            nombre = "Album",
            cover = R.raw.cover,
            genre = "Pop"
        )
        ,Album(
            artista = "Profe",
            canciones = listOf(),
            nombre = "Album",
            cover = R.raw.cover,
            genre = "Pop"
        )
        ,Album(
            artista = "Profe",
            canciones = listOf(),
            nombre = "Album",
            cover = R.raw.cover,
            genre = "Pop"
        )
    )
    Column(
        modifier = modifier.fillMaxSize(),
    ){
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize().padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)

        ) {
            /*item{
                Text("Hola")

            }*/

            items(lista){elemento ->
                AlbumCard(elemento)
            }
            /*
            item{
                Text("Hola")

            }

             */
        }
    }
}

@Composable
fun AlbumCard(album: Album){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        )
    ){
        Image(
            painter = painterResource(album.cover),
            contentDescription = null,
            modifier = Modifier.clip(RoundedCornerShape(10.dp))
        )
        Text("Album", fontWeight = FontWeight.Bold)
        Text("Artista")
    }
}