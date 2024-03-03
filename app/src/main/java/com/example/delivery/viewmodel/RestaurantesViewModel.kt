package com.example.delivery.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.delivery.modelo.Restaurante
import com.example.delivery.retrofit.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RestaurantesViewModel: ViewModel() {

    private val _restaurantes = MutableLiveData<List<Restaurante>>()
    val restaurantes: LiveData<List<Restaurante>> = _restaurantes

    fun getRestaurantes() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getRestaurantes()
            withContext(Dispatchers.Main) {
               if (response.body()!!.codigo == "200") {
                    _restaurantes.value = response.body()!!.data
               }
            }
        }
    }

}