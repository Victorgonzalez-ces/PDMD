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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AdapterProductos(var context: Context, var auth: FirebaseAuth): RecyclerView.Adapter<AdapterProductos.MyHolder>() {

    private lateinit var listaProductos: ArrayList<Producto>
    private lateinit var database: FirebaseDatabase


    init {
        listaProductos = ArrayList()
        database = FirebaseDatabase.getInstance("https://vgp-ces-default-rtdb.europe-west1.firebasedatabase.app/")
    }
    class MyHolder(item: View): RecyclerView.ViewHolder(item){
        var toolbar: Toolbar
        var imageView: ImageView

        init {
            toolbar = item.findViewById(R.id.toolbar_carta)
            toolbar.inflateMenu(R.menu.menu_carta)
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
        holder.toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.menu_fav_item->{
                    addFavoritos(item)
                }
            }
            return@setOnMenuItemClickListener true

        }
        Glide.with(context).load(item.imagen).into(holder.imageView)

    }

    fun detalleProducto(){}
    fun addFavoritos(producto: Producto){
        val referencia = database.getReference("usuarios").child(auth.currentUser!!.uid).child("favoritos")
        referencia.child("Nombre Producto").setValue(producto.nombre)
        referencia.child("Categoria").setValue(producto.categoria)
        referencia.child("precio").setValue(producto.precio)
    }

    fun addProducto(producto: Producto){
        listaProductos.add(producto)
        notifyItemInserted(listaProductos.size-1)
    }
}