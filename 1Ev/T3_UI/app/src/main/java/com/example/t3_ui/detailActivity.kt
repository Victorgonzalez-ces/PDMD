package com.example.t3_ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.t3_ui.databinding.ActivityDetailBinding
import com.example.t3_ui.model.Modelo

class detailActivity: AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var modelo: Modelo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        modelo = intent.extras!!.getSerializable("modelo") as Modelo
    }

    override fun onStart() {
        super.onStart()
        binding.imagenModelo.setImageResource(modelo.imagen)
    }
}