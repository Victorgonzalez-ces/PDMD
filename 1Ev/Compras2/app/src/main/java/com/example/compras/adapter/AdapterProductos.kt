package com.example.compras.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.compras.R
import com.example.compras.model.Producto

class AdapterProductos(var lista: ArrayList<Producto>,var contexto:Context):
    RecyclerView.Adapter<AdapterProductos.MyHolder>(){

    private lateinit var listener: OnProductoListener

    init {
        listener = contexto as OnProductoListener
    }
    class MyHolder(item: View) : RecyclerView.ViewHolder(item){
        var imagenProducto: ImageView
        var textoNombre: TextView
        init {
            imagenProducto = item.findViewById(R.id.imagen_producto)
            textoNombre = item.findViewById(R.id.nombre_producto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista = LayoutInflater.from(contexto).inflate(R.layout.recycler_productos,parent,false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item = lista[position]
        holder.textoNombre.text = item.title


    }

    interface OnProductoListener{
        fun onProductoSelected(producto: Producto)
    }
}