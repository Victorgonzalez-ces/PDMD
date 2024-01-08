package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.fragment.FragmentUno

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.sitioFragment
        //supportFragmentManager-> gestion de fragments
        //supportFragmentManager-> fragmentTransaction
        //1. Crear el objeto del cuadro de dialogo
        //2. show(supportFragmentManager,null)
        var ft = supportFragmentManager.beginTransaction()
        //fragment transaction
        //replace
        ft.replace(binding.sitioFragment.id,FragmentUno(),"f1")
        ft.addToBackStack("f1")
        ft.commit()

        ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.sitioFragment.id,FragmentUno(),"f1")
        ft.addToBackStack("f2")
        ft.commit()

        //add
        //remove
    }

    override fun onBackPressed() {
        if (supportFragmentManager.)
        super.onBackPressed()
    }
}