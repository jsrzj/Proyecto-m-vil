package com.example.delivery.navegacion

sealed class Vistas(val ruta: String) {

    object Registro: Vistas("Registro")

    object Login: Vistas("Login")

    object Home: Vistas("Home")

    object Promociones: Vistas("Promociones")

}