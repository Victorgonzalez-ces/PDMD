package com.example.t5_navegacion.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toolbar
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.t5_navegacion.R
import com.example.t5_navegacion.model.Producto

class AdapterProductos(var context: Context): RecyclerView.Adapter<AdapterProductos.MyHolder>(){

    private lateinit var listaProductos: ArrayList<Producto>

    init {
        listaProductos = ArrayList()
    }
    class MyHolder(item: View): RecyclerView.ViewHolder(item){
         var toolbar: Toolbar
         var imagen: ImageView

        init {
            toolbar = item.findViewById(R.id.toolbarCarta)
            imagen = item.findViewById(R.id.imagenProducto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View = LayoutInflater.from(context).inflate(R.layout.item_producto,parent,false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return this.listaProductos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: Producto = listaProductos[position]
        holder.toolbar.title = item.nombre
        holder.toolbar.inflateMenu(R.menu.menu_toolbar)
        Glide.with(context).load(item.imagen).into(holder.imagen)
    }

    fun addProducto(item: Producto){
        listaProductos.add(item)
        notifyItemInserted(listaProductos.size-1)
    }

}