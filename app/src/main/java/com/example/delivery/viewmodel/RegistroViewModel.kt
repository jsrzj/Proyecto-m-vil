package com.example.delivery.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.delivery.modelo.Usuario
import com.example.delivery.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegistroViewModel: ViewModel() {

    private val _nombre = MutableLiveData<String>()
    val nombre: LiveData<String> = _nombre

    private val _apellidos = MutableLiveData<String>()
    val apellidos: LiveData<String> = _apellidos

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _telefono = MutableLiveData<String>()
    val telefono: LiveData<String> = _telefono

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun cambiarInputs(nombre: String, apellidos: String, email: String, telefono: String, password: String) {
        _nombre.value = nombre
        _apellidos.value = apellidos
        _email.value = email
        _password.value = password
        _telefono.value = telefono
    }

    fun registrarUsuario(nombre: String, apellidos: String, email: String, telefono: String, password: String) {
        val usuario = Usuario(nombre, apellidos, email, telefono, password)
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.registrarUsuario(usuario)
            withContext(Dispatchers.Main) {
                if(response.body()!!.codigo == "200") {
                    //getUsuarios()
                }
            }
        }
    }







}