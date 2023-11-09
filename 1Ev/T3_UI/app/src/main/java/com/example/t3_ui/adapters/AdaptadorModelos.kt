package com.example.t3_ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.t3_ui.R
import com.example.t3_ui.model.Modelo

class AdaptadorModelos(var listaModelos: ArrayList<Modelo>, var contexto: Context): BaseAdapter() {


    //cuantos elementos tiene el elemento gráfico (spinner)
    override fun getCount(): Int {
        return listaModelos.size
    }

    //el elemento que esta en el spinner en la posición concreta (p0)
    override fun getItem(p0: Int): Modelo {
        return listaModelos[p0]
    }

    //el id del elemento seleccionado en el spinner en una posición en concreto
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    //rellenar la fila con los datos que le corresponde
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        // XML -> layout --> (elementos)
        //Objeto de la posición
        val vista: View = LayoutInflater.from(contexto).inflate(R.layout.itemmodelo,p2, false)
        val modelo = listaModelos[p0]
        val imageView: ImageView = vista.findViewById(R.id.imagenModelo)
        val nombreText: TextView = vista.findViewById(R.id.nombreModelo)
        imageView.setImageResource(modelo.imagen)
        nombreText.text = modelo.nombre

        return
    }

    fun addModelos(modelo: Modelo){
        listaModelos.clear()
        listaModelos.add(modelo)
        notifyDataSetChanged()
    }
    fun setLista(lista: ArrayList<Modelo>){
        listaModelos.clear()
        listaModelos.addAll(lista)
        notifyDataSetChanged()
    }
}