package com.example.t3_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.t3_ui.adapters.AdaptadorModelos
import com.example.t3_ui.databinding.ActivitySecondBinding
import com.example.t3_ui.model.Marca
import com.example.t3_ui.model.Modelo
import com.example.t3_ui.model.Usuario
import com.google.android.material.navigation.NavigationBarView

class SecondActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener {


    private lateinit var binding: ActivitySecondBinding
    private var usuario: Usuario? = null;
    private lateinit var listaMarcas: ArrayList<Marca>
    private lateinit var listaModelos: ArrayList<Modelo>
    private lateinit var adaptadorMarcas: ArrayAdapter<Marca>
    private lateinit var adaptadorModelos: AdaptadorModelos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // instancias
        usuario = intent.extras?.getSerializable("usuario") as Usuario
        listaMarcas = ArrayList();

        adaptadorMarcas = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item,
            listaMarcas)
        listaModelos = ArrayList()
        adaptadorModelos = AdaptadorModelos(listaModelos)

    }

    override fun onStart() {
        super.onStart()
        // cambios graficos
        // poner el correo en su sitio
        listaMarcas.add(Marca("Mercedes",43,R.drawable.mercedes220))
        listaMarcas.add(Marca("Audi",46,R.drawable.audirs6))
        listaMarcas.add(Marca("Ford",40,R.drawable.fordgt))

        binding.spinnerMarcas.adapter = adaptadorMarcas
        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.nombreUsuario.text = usuario?.correo ?: "Invitado"
        listaModelos.add(Modelo("GT40","Ford",300,14000,"clasico", R.drawable.fordgt))
        binding.spinnerModelos.adapter = adaptadorModelos
    }

    override fun onResume() {
        super.onResume()
        // para acciones
        binding.imagenLogout.setOnClickListener(this)
        binding.botonAdd.setOnClickListener(this)
        binding.spinnerMarcas.onItemSelectedListener = this;
        binding.spinnerModelos.onItemSelectedListener = this;
    }

    override fun onClick(v: View?) {
        when(v?.id){
            binding.imagenLogout.id ->{
                finish()
            }
            binding.botonAdd.id ->{
                // añadir un modelo al spinner
                Modelo("E-tron", "Mercedes",400,150000, "Electrico",)
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent?.id){
            binding.spinnerMarcas.id->{
                val marca = binding.spinnerMarcas.selectedItem as Marca
                var lista: ArrayList<Modelo> = ArrayList()
                if (marca.equals("Mercedes")){
                    lista.add(Modelo("C220","Mercedes",300,300000,"Deportivo",R.drawable.mercedes220))
                }else if (marca.equals("Audi"))
                binding.imagenLogout.setImageResource(marca.imagen)
                binding.textoInfo.text = marca.valoracion.toString()
            }
            binding.spinnerModelos.id->{
                val marca = binding.spinnerModelos.selectedItem as Marca
                binding.imagenLogout.setImageResource(marca.imagen)
                binding.textoInfo.text = marca.valoracion.toString()
            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        parent?.adapter?.getItem(binding.spinnerModelos.selectedItemPosition)
    }
}