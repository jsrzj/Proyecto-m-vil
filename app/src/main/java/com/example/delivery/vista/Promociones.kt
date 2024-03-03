package com.example.delivery.vista

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.delivery.R
import com.example.delivery.navegacion.Vistas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Promociones(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(

                ),
                title = {
                    Text(
                        text = "Promociones",
                        fontSize = 17.sp,
                        modifier = Modifier
                            .clickable {

                            }
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.White,
                actions = {
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(-10.dp)
                        ) {
                            IconButton(onClick = { navController.navigate(Vistas.Home.ruta) }) {
                                Icon(
                                    painterResource(id = R.drawable.home_icon),
                                    contentDescription = null,
                                    tint = Color(170, 170, 170),
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                            Text(
                                text = "Home",
                                fontSize = 13.sp,
                                color = Color(170, 170, 170)
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(-10.dp)
                        ) {
                            IconButton(onClick = { navController.navigate(Vistas.Promociones.ruta) }) {
                                Icon(
                                    painterResource(id = R.drawable.discount_icon),
                                    contentDescription = null,
                                    tint = Color(100, 100, 100),
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                            Text(
                                text = "Promociones",
                                fontSize = 13.sp,
                                color = Color(100, 100, 100)
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(-10.dp),
                            modifier = Modifier.clickable { /* handle click */ }
                        ) {
                            IconButton(onClick = { /* do something */ }) {
                                Icon(
                                    painterResource(id = R.drawable.order_icon),
                                    contentDescription = null,
                                    tint = Color(170, 170, 170),
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                            Text(
                                text = "Pedidos",
                                fontSize = 13.sp,
                                color = Color(170, 170, 170)
                            )
                        }
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(-9.dp),
                            modifier = Modifier.clickable { /* handle click */ }
                        ) {
                            IconButton(onClick = { /* do something */ }) {
                                Icon(
                                    painterResource(id = R.drawable.user_icon),
                                    contentDescription = null,
                                    tint = Color(170, 170, 170),
                                    modifier = Modifier.size(35.dp)
                                )
                            }
                            Text(
                                text = "Mi perfil",
                                fontSize = 13.sp,
                                color = Color(170, 170, 170)
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier
                    .padding(28.dp)
            ) {
                items(10) { index ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .border(1.dp, Color.Black)
                    ) {

                    }
                }
            }
        }
    }
}