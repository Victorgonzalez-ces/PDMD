package com.example.t2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var botonEmpezar: Button
    private lateinit var textoIntroducirNombre: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instancias()
        setContentView(R.layout.activity_main)
    }

    private fun instancias(){
        botonEmpezar = findViewById(R.id.ButtonEmpezar)
        textoIntroducirNombre = findViewById(R.id.textoIntroducirNombre)
    }

    private fun acciones(){
        botonEmpezar.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0!!.id == R.id.ButtonEmpezar){
           val nombre = textoIntroducirNombre.text.toString()
            if (nombre.isEmpty()) {
                // El EditText está vacío, muestra una Snackbar
                Snackbar.make(
                    it
                    ,"Por favor, introduzca su nombre",
                    Snackbar.LENGTH_SHORT
                ).show()
        }
    }
}