package com.example.victor_gonzalez_dam2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.victor_gonzalez_dam2.R
import com.example.victor_gonzalez_dam2.model.Restaurante

class RestauranteAdaptador(var contexto: Context, var listaDatos: List<Restaurante>): RecyclerView.Adapter<RestauranteAdaptador.MyHolder>(){

    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {
        var nombre: TextView
        var imagen: ImageView
        init {
            nombre = view.findViewById(R.id.nombre)
            imagen = view.findViewById(R.id.imagen)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.recycler_restaurante, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

    }
}