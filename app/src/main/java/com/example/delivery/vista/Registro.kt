package com.example.delivery.vista

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.delivery.R
import com.example.delivery.navegacion.Vistas
import com.example.delivery.viewmodel.LoginViewModel
import com.example.delivery.viewmodel.RegistroViewModel

@Composable
fun Registro(navController: NavController, viewModel: RegistroViewModel) {
    val nombre: String by viewModel.nombre.observeAsState(initial = "")
    val apellidos: String by viewModel.apellidos.observeAsState(initial = "")
    val email: String by viewModel.email.observeAsState(initial = "")
    val telefono: String by viewModel.telefono.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(70.dp))
                Text(
                    text = "Regístrate",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(40.dp))
                RegistroTextField(value = nombre, onValueChange = { viewModel.cambiarInputs(it, apellidos, email, telefono, password) }, label = "Nombre")

                Spacer(modifier = Modifier.height(15.dp))
                RegistroTextField(value = apellidos, onValueChange = { viewModel.cambiarInputs(nombre, it, email, telefono, password) }, label = "Apellidos")

                Spacer(modifier = Modifier.height(15.dp))
                RegistroTextField(value = email, onValueChange = { viewModel.cambiarInputs(nombre, apellidos, it, telefono, password) }, label = "E-mail")

                Spacer(modifier = Modifier.height(15.dp))
                RegistroTextField(value = telefono, onValueChange = { viewModel.cambiarInputs(nombre, apellidos, email, it, password) }, label = "Teléfono")

                Spacer(modifier = Modifier.height(15.dp))
                RegistroTextField(value = password, onValueChange = { viewModel.cambiarInputs(nombre, apellidos, email, telefono, it) }, label = "Contraseña")

                Spacer(modifier = Modifier.height(21.dp))
                Box {
                    Column {
                        Button(
                            onClick = {
                                viewModel.registrarUsuario(nombre, apellidos, email, telefono, password)
                                navController.navigate(Vistas.Login.ruta)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(44.dp),
                            colors = ButtonDefaults.buttonColors(Color(234, 4, 78)),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Text(
                                text = "Regístrate"
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "¿Ya tienes una cuenta?",
                                color = Color(140,140,140)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = "Inicia sesión",
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .clickable {
                                        navController.navigate(Vistas.Login.ruta)
                                    }
                            )
                        }
                    }
                }
            }
        }
        Box {
            Image(
                painter = painterResource(id = R.drawable.vector_auth),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun RegistroTextField(value: String, onValueChange: (String) -> Unit, label: String) {
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth(),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color(210,210,210)
        )
    )
}