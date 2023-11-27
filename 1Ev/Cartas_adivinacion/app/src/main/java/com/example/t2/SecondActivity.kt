package com.example.t2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import kotlin.random.Random

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var botonMas: ImageButton
    private lateinit var botonMenos: ImageButton
    private val imagenesCartas= intArrayOf(
        R.drawable.c1,
        R.drawable.c2,
        R.drawable.c3,
        R.drawable.c4,
        R.drawable.c5,
        R.drawable.c6,
        R.drawable.c7,
        R.drawable.c8,
        R.drawable.c9,
        R.drawable.c10,
        R.drawable.c11,
        R.drawable.c12,
        R.drawable.c13,
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        instancias()
        acciones()
    }

    private fun instancias(){
        botonMas = findViewById(R.id.botonMas)
        botonMenos = findViewById(R.id.botonMenos)
    }

    private fun acciones() {
        botonMas.setOnClickListener(this)
        botonMenos.setOnClickListener(this)
    }
    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.botonMas->{
                val intent:
            }

        }
    }

    fun generaAleatorio(): Int{
        return Random.nextInt(13)
    }
}