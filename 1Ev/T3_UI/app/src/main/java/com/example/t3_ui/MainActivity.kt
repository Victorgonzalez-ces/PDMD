package com.example.t3_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import com.example.t3_ui.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonLimpiar.setOnClickListener(this)
        binding.botonRegistrar.setOnClickListener(this)
        binding.grupoTipo.setOnCheckedChangeListener { _, checkedId ->
            val seleccion = (this.findViewById<RadioButton>(checkedId)).text
            Snackbar.make(binding.root, seleccion, Snackbar.LENGTH_SHORT).show()
        }
        binding.spinnerPerfil.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //binding.spinnerPerfil.selectedItem
                val seleccionado = parent?.adapter?.getItem(position).toString()
                Snackbar.make(binding.root, seleccionado, Snackbar.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.botonLimpiar.id->{}
            binding.botonRegistrar.id->{
                val seleccionado = binding.spinnerPerfil.selectedItem.toString()
                val seleccion = findViewById(checkedRadioButton).text
                Snackbar.make(binding.root, seleccionado, Snackbar.LENGTH_SHORT).show()
                Toast.makeText(applicationContext, seleccion, Toast.LENGTH_SHORT).show()
            }
        }
    }
}