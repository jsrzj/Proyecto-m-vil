package com.example.delivery.repositorios

import com.example.delivery.modelo.RestaurantesResponse
import com.example.delivery.modelo.Usuario
import com.example.delivery.modelo.UsuariosResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface WebService {

    @POST("/api/auth/registro")
    suspend fun registrarUsuario(@Body usuario: Usuario): Response<UsuariosResponse>

    @GET("/api/restaurantes")
    suspend fun getRestaurantes(): Response<RestaurantesResponse>

}