package com.example.fragments.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.databinding.FragmentUnoBinding
import com.google.android.material.snackbar.Snackbar

class FragmentUno: Fragment() {

    private lateinit var context: Context
    private lateinit var binding: FragmentUnoBinding
    private lateinit var listener: onFragmentUnoListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        this.listener = context as onFragmentUnoListener
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUnoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.botonComunicar.setOnClickListener{
            listener.onNombreSelected(binding.editNombre.text.toString())
            //binding.editNombre.text.toString()
            //Snackbar.make(binding.root,binding.editNombre.text.toString(),Snackbar.LENGTH_SHORT).show()
        }
    }

    interface onFragmentUnoListener{
        fun onNombreSelected(nombre: String)
    }
    override fun onDetach() {
        super.onDetach()
    }
}