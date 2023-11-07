package com.example.t3_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.t3_ui.databinding.ActivitySecondBinding
import com.example.t3_ui.model.Usuario

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySecondBinding
    private var usuario: Usuario? = null
    private lateinit var listaMarcas: ArrayList<CharSequence>
    private lateinit var adaptadorMarcas: ArrayAdapter<CharSequence>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //instancias
        usuario = intent.extras?.getSerializable("usuario") as Usuario
        listaMarcas = ArrayList()
        listaMarcas.add("mercedes")
        listaMarcas.add("audi")
        listaMarcas.add("ford")
        adaptadorMarcas = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, listaMarcas)
    }

    override fun onStart() {
        super.onStart()
        //cambios graficos
        binding.spinnerMarcas.adapter = adaptadorMarcas
        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.nombreUsuario.text = usuario?.correo ?: "Invitado"
    }

    override fun onResume() {
        super.onResume()
        binding.imagenLogout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.imagenLogout.id ->{
                finish()
            }
        }
    }
}