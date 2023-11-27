package com.example.t3_listproductos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import com.example.t3_listproductos.adapter.AdaptadorProductos
import com.example.t3_listproductos.databinding.ActivityMainBinding
import com.example.t3_listproductos.model.Producto

class MainActivity : AppCompatActivity() {

   private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}