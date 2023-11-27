package com.example.t2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.make

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var botonEmpezar: Button
    private lateinit var textoIntroducirNombre: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instancias()
        acciones()
        setContentView(R.layout.activity_main)
    }

    private fun instancias() {
        botonEmpezar = findViewById(R.id.ButtonEmpezar)
        textoIntroducirNombre = findViewById(R.id.textoIntroducirNombre)
    }

    private fun acciones() {
        botonEmpezar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0!!.id == R.id.ButtonEmpezar) {
            val nombre = textoIntroducirNombre.text.toString()
            if (nombre.isEmpty()) {
                Snackbar.make(p0, "Por favor, introduzca su nombre", Snackbar.LENGTH_SHORT).show()
            }else{
                Snackbar.make(p0, "Hola, $nombre. Bienvenido al juego", Snackbar.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, SecondActivity::class.java)
                startActivity(intent)
            }
        }
    }
}