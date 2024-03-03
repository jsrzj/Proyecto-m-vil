package com.example.delivery.modelo

data class Usuario(
    val nombre: String = "",
    val apellidos: String = "",
    val email: String = "",
    val telefono: String = "",
    val password: String = "",
) {
    val _id: String = ""
}