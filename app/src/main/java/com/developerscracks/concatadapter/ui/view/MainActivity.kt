package com.developerscracks.concatadapter.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.developerscracks.concatadapter.R
import com.developerscracks.concatadapter.databinding.ActivityMainBinding
import com.developerscracks.concatadapter.ui.viewmodel.PeliculaViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PeliculaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[PeliculaViewModel::class.java]

        viewModel.isConnected.observe(this) { isConnected ->
            if (isConnected) {
                binding.tvText.text = "Hay conexión"
                Log.d("TAG", viewModel.getInfoMovies().toString())
            } else {
                binding.tvText.text = "No hay conexión"
                Log.d("TAG", viewModel.getInfoMovies().toString())
            }

            binding.swipeRefreshLayout.isRefreshing = false
        }

        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.checkInternetConnection()

        }

        viewModel.checkInternetConnection()
    }
}