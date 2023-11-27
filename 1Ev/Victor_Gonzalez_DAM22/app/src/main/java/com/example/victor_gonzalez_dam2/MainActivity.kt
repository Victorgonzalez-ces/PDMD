package com.example.victor_gonzalez_dam2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ArrayAdapter
import androidx.core.view.get
import com.example.victor_gonzalez_dam2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        datosSpinners()
    }

    override fun onClick(v: View?) {
        when(v){
            binding.botonBuscar->{
                val intent = Intent(applicationContext,SecondActivity::class.java)
                startActivity(intent)
            }

        }
    }
    private fun datosSpinners(){
        val adapterPuntuacion = ArrayAdapter.createFromResource(this,R.array.puntuacion,android.R.layout.simple_spinner_item)
        adapterPuntuacion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPuntuacion.adapter = adapterPuntuacion

        val adapterComida = ArrayAdapter.createFromResource(this,R.array.comida,android.R.layout.simple_spinner_item)
        adapterComida.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerComida.adapter = adapterComida

        val adapterLocalidad = ArrayAdapter.createFromResource(this,R.array.Localidad,android.R.layout.simple_spinner_item)
        adapterLocalidad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerLocalidad.adapter = adapterLocalidad
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)

    }
}