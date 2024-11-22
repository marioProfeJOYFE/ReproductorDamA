package com.mrh.reproductor

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.graphics.vector.ImageVector

enum class NavBarValues (
    val label: String? = null,
    val icon: ImageVector? = null,
    val root: String,
    val route: String
) {
    INICIO(
        label = "Inicio",
        icon = Icons.Filled.Home,
        root = "inicio",
        route = "list_albums_view"
    ),
    ALBUM(
        root = "inicio",
        route = "album_view/{posicion}"
    ),
    PLAYLISTS(
        label = "PlayLists",
        icon = Icons.Filled.Menu,
        root = "seccion_2",
        route = "list_playlists"
    )
}