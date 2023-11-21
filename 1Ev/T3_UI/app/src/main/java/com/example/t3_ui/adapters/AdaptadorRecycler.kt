package com.example.t3_ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.t3_ui.R
import com.example.t3_ui.detailActivity
import com.example.t3_ui.model.Modelo
import com.google.android.material.snackbar.Snackbar

class AdaptadorRecycler(var lista: ArrayList<Modelo>, var contexto: Context): RecyclerView.Adapter<AdaptadorRecycler.MyHolder>() {

    class MyHolder (item: View): RecyclerView.ViewHolder(item){

        var imagen: ImageView
        var nombre: TextView
        var precio: TextView
        var boton: Button

        init {
            imagen = item.findViewById(R.id.imagen_modelo)
            nombre = item.findViewById(R.id.nombre_modelo)
            precio = item.findViewById(R.id.precio_modelo)
            boton = item.findViewById(R.id.boton_registrar)
        }
    }
    //Indica el número de elementos a pintar
    override fun getItemCount(): Int {
        return lista.size
    }
    //crea un patrón
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        // view -> XML
        val view: View = LayoutInflater.from(contexto).inflate(R.layout.itemrecycler,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val item: Modelo = lista[position]
        holder.imagen.setImageResource(item.imagen)
        holder.nombre.text = item.nombre
        holder.precio.text = item.precio.toString()
        holder.boton.setOnClickListener {

            val intent: Intent = Intent(contexto, detailActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("modelo",item)
            contexto.startActivity(intent)

        }
        holder.imagen.setOnLongClickListener{
            notifyItemRemoved(position)
            lista.removeAt(position)
            return@setOnLongClickListener true
        }
    }

}