package com.example.victorgonzalez_t2_pdmd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SecondActivity : AppCompatActivity() {
    private lateinit var imagen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instancias()
    }

    private fun instancias() {
        imagen = findViewById(R.id.imagen)
    }

    private fun acciones(){
    }


}