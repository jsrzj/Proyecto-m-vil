package com.example.delivery.modelo

data class RestaurantesResponse(
    var codigo: String,
    var mensaje: String,
    var data: ArrayList<Restaurante>
) {

}