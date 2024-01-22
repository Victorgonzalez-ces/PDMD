package com.example.fragments.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.FragmentDosBinding

class FragmentDos: Fragment() {

    private lateinit var context: Context
    private lateinit var binding: FragmentDosBinding
    private lateinit var textoRecuperado: String
    companion object{
        fun newInstance(nombre: String): FragmentDos {

            val fragmentDos: FragmentDos = FragmentDos()
            val bundle: Bundle = Bundle()
            bundle.putString("nombre",nombre)
            fragmentDos.arguments = bundle
            return fragmentDos
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        textoRecuperado = arguments?.getString("nombre") ?: "Sin nombre"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.textoNombre.text = textoRecuperado
    }
    override fun onDetach() {
        super.onDetach()
    }
}