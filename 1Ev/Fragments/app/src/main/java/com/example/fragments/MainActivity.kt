package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.View.OnClickListener
import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.fragment.FragmentDos
import com.example.fragments.fragment.FragmentUno

class MainActivity : AppCompatActivity(), OnClickListener, FragmentUno.onFragmentUnoListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
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
        ft.addToBackStack("f11")
        ft.commit()

        //add
        //remove
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            /*binding.f1Buton.id->{
                var ft = supportFragmentManager.beginTransaction()
                ft.replace(binding.sitioFragment.id,FragmentUno(),"f1")
                ft.addToBackStack("f1")
                ft.commit()
            }
            binding.f2Buton.id->{
                var ft = supportFragmentManager.beginTransaction()
                ft.replace(binding.sitioFragment.id, FragmentDos(),"f2")
                ft.addToBackStack("f2")
                ft.commit()
            }*/
        }
    }

    override fun onNombreSelected(nombre: String) {
        supportActionBar!!.title = "Fragment dos"
        var ft = supportFragmentManager.beginTransaction()
        ft.replace(binding.sitioFragment.id, FragmentDos.newInstance(nombre),"f2")
        ft.addToBackStack("f2")
        ft.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
}