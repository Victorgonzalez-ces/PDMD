package com.example.victorgonzalez_dam2_pmdmt6

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.victorgonzalez_dam2_pmdmt6.databinding.FragmentMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MainFragment : Fragment() {


    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapterSpinner: ArrayAdapter<String>
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val items = arrayListOf("basico","tecnología","ropa")
        adapterSpinner = ArrayAdapter(context,android.R.layout.simple_spinner_item)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerCategoria.adapter = adapterSpinner
        database = FirebaseDatabase.getInstance("https://vgp-ces-default-rtdb.europe-west1.firebasedatabase.app/")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.botonGuardar.setOnClickListener {
            if (binding.editId.text.toString() != "" &&
                binding.editNombreProduct.text.toString() != "" &&
                binding.editPrecio.text.toString() != "" &&
                binding.editStock.text.toString() != "" &&
                binding.editDescripcion.text.toString() != "" &&
                binding.grupoRadio.checkedRadioButtonId == -1){

                val referencia = database.getReference("Products").child(binding.editId.text.toString())
                referencia.child("nombre").setValue(binding.editId.text.toString())
                referencia.child("precio").setValue(binding.editPrecio.text.toString())
                referencia.child("Stock").setValue(binding.editStock.text.toString())
                referencia.child("descripcion").setValue(binding.editDescripcion.text.toString())
                referencia.child("Categoria").setValue(binding.spinnerCategoria.selectedItem.toString())
                if (binding.radioPaypal.isSelected){
                    referencia.child("Modo pago").setValue(binding.radioPaypal.text.toString())
                }else{
                    referencia.child("Modo pago").setValue(binding.radioTarjeta.text.toString())
                }

                binding.editNombreProduct.setText("")
                binding.editPrecio.setText("")
                binding.editStock.setText("")
                binding.editDescripcion.setText("")
            }else{
                Snackbar.make(binding.root,"Se han introducido datos vacios", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

   override fun onDestroyView() {
        super.onDestroyView()
    }
}