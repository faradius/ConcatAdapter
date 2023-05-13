package com.developerscracks.concatadapter.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developerscracks.concatadapter.data.database.FakeDataBase
import com.developerscracks.concatadapter.data.model.Pelicula
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Socket

class PeliculaViewModel: ViewModel() {

    private var _mensaje = MutableLiveData<String>()
    val mensaje: LiveData<String> get() = _mensaje

    private val _isConnected = MutableLiveData<Boolean>()
    val isConnected: LiveData<Boolean> get() = _isConnected

    fun checkInternetConnection() {
        viewModelScope.launch {
            val connected = withContext(Dispatchers.IO) {
                isInternetAvailable()
            }
            _isConnected.value = connected
        }
    }

    private fun isInternetAvailable(): Boolean {
        return try {
            val sock = Socket()
            val socketAddress = InetSocketAddress("8.8.8.8", 53)
            sock.connect(socketAddress,2000)
            sock.close()
            true
        } catch (e: IOException) {
            false
        }
    }

    fun getInfoMovies():List<Pelicula>{
        return if(_isConnected.value == true){
            FakeDataBase.peliculas()
        }else{
            emptyList()
        }
    }
}