package com.example.t3_listproductos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.t3_listproductos.model.Producto
import com.example.t3_listproductos.R

class AdaptadorProductos(var lista: ArrayList<Producto>, var contexto: Context): RecyclerView.Adapter<AdaptadorProductos.MyHolder>() {
    class MyHolder(item: View): ViewHolder(item){
        var carta: CardView
        var textoNombre: TextView
        var viewImagen: ImageView

        init {
            carta = item.findViewById(R.id.carta)
            textoNombre = item.findViewById(R.id.nombre_producto)
            viewImagen = item.findViewById(R.id.imagen_producto)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler,parent,false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = lista[position]
        holder.textoNombre.text = item.nombre

        Glide.with(contexto).load(item.imagen).placeholder(R.drawable.defecto)
            .into(holder.viewImagen)
        
    }
}