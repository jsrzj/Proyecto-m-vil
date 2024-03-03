package com.example.delivery.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.delivery.viewmodel.LoginViewModel
import com.example.delivery.viewmodel.RegistroViewModel
import com.example.delivery.viewmodel.RestaurantesViewModel
import com.example.delivery.vista.Home
import com.example.delivery.vista.Login
import com.example.delivery.vista.Promociones
import com.example.delivery.vista.Registro

@Composable
fun Navegacion() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Vistas.Login.ruta) {
        composable("${Vistas.Login.ruta}") {
            Login(
                navController = navController,
                viewModel = LoginViewModel()
            )
        }
        composable("${Vistas.Registro.ruta}") {
            Registro(
                navController = navController,
                viewModel = RegistroViewModel()
            )
        }
        composable("${Vistas.Home.ruta}") {
            Home(
                navController = navController,
                viewModel = RestaurantesViewModel()
            )
        }
        composable("${Vistas.Promociones.ruta}") {
            Promociones(
                navController = navController
            )
        }
    }
}