package com.example.repasoexamenfinal.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.repasoexamenfinal.R
import com.example.repasoexamenfinal.model.Producto
import com.google.firebase.database.FirebaseDatabase

class AdapterProductos(var context: Context,var uid: String): RecyclerView.Adapter<AdapterProductos.MyHolder>(){

    private var listaProductos: ArrayList<Producto?>
    private var dbd = FirebaseDatabase.getInstance("https://vgp-ces-default-rtdb.europe-west1.firebasedatabase.app/")
    init {
        listaProductos = ArrayList()
    }
    class MyHolder(item: View): RecyclerView.ViewHolder(item){
        var toolbar:Toolbar
        var imagen :ImageView

        init {
            toolbar = item.findViewById(R.id.toolbar_carta)
            imagen = item.findViewById(R.id.imagen_producto)
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
        val item: Producto? = listaProductos[position]
        holder.toolbar.title = item?.title
        Glide.with(context).load(item?.thumbnail).into(holder.imagen)

        listaProductos.forEach {
            val referencia = dbd.getReference("ejemplo").child(it?.id.toString())
            referencia.setValue(it)
        }
    }

    fun borrarLista(){
        this.listaProductos.clear()
        notifyDataSetChanged()
    }
    fun addProducto(producto: Producto?){
        this.listaProductos.add(producto)
        notifyItemInserted(listaProductos.size-1)
    }

}