package com.example.t3_ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.view.children
import androidx.core.view.get
import com.example.t3_ui.databinding.ActivityMainBinding
import com.example.t3_ui.model.Usuario
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var perfil: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.botonLimpiar.setOnLongClickListener {

            binding.editCorreo.text.clear()
            binding.editNombre.text.clear()
            binding.editPass.text.clear()
            binding.grupoTipo.clearCheck()
            binding.spinnerPerfil.setSelection(0)
            binding.checkRecordad.isChecked = false
            return@setOnLongClickListener true
        }
        binding.botonLimpiar.setOnClickListener(this)
        binding.botonRegistrar.setOnClickListener(this)
        binding.grupoTipo.setOnCheckedChangeListener { _, checkedId ->
            //Snackbar.make(binding.root, seleccion, Snackbar.LENGTH_SHORT).show()
            if (checkedId>-1){
                val seleccion = (this.findViewById<RadioButton>(checkedId)).text
                binding.checkRecordad.isEnabled = !seleccion.equals("mensual")
            }
        }
        binding.spinnerPerfil.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //binding.spinnerPerfil.selectedItem
                val seleccionado = parent?.adapter?.getItem(position).toString()
                perfil = parent?.adapter?.getItem(position).toString()
                //Snackbar.make(binding.root, seleccionado, Snackbar.LENGTH_SHORT).show()
                if (seleccionado.equals("Invitado",true)){
                    binding.grupoTipo.isEnabled = false
                    binding.checkRecordad.isEnabled = false
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.botonLimpiar.id->{

            }
            binding.botonRegistrar.id->{
                if (!binding.editNombre.text.isEmpty() && !binding.editCorreo.text.isEmpty() && !binding.editPass.text.isEmpty() && (!binding.equals("invitado") && binding.grupoTipo.checkedRadioButtonId>-1)){
                    val intent = Intent(applicationContext,SecondActivity::class.java)
                    val usuario = Usuario(binding.editNombre.text.toString(),
                        binding.editPass.text.toString(),
                        binding.editCorreo.text.toString(),
                        binding.spinnerPerfil.selectedItem.toString(),
                        findViewById<RadioButton>(binding.grupoTipo.checkedRadioButtonId).text.toString(),
                        binding.checkRecordad.isChecked)
                    intent.putExtra("usuario",usuario)
                    startActivity(intent)
                }else{
                    Snackbar.make(binding.root, "faltan datos por rellenar", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}