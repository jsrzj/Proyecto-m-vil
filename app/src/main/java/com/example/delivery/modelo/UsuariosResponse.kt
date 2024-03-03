package com.example.delivery.modelo

data class UsuariosResponse(
    var codigo: String,
    var mensaje: String,
    var data: ArrayList<Usuario>
)