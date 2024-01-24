package com.example.repaso_t6.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.repaso_t6.R
import com.example.repaso_t6.model.Producto

class AdapterProductos(var context: Context): RecyclerView.Adapter<AdapterProductos.MyHolder>() {

    private lateinit var listaProductos: ArrayList<Producto>

    init {
        listaProductos = ArrayList()
    }
    class MyHolder(item: View): RecyclerView.ViewHolder(item){
        var toolbar: Toolbar
        var imageView: ImageView

        init {
            toolbar = item.findViewById(R.id.toolbar_carta)
            imageView = item.findViewById(R.id.imagen_producto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val vista: View = LayoutInflater.from(context).inflate(R.layout.item_producto,parent,false)
        return MyHolder(vista)
    }

    override fun getItemCount(): Int {
        return listaProductos.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: Producto = listaProductos[position]
        holder.toolbar.title = item.nombre
        holder.toolbar.inflateMenu(R.menu.menu_carta)
        Glide.with(context).load(item.imagen).into(holder.imageView)

    }

    fun detalleProducto(){}

    fun addProducto(producto: Producto){
        listaProductos.add(producto)
        notifyItemInserted(listaProductos.size-1)
    }
}