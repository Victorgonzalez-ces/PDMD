package com.example.t5_navegacion.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.t5_navegacion.adapter.AdapterProductos
import com.example.t5_navegacion.databinding.FragmentDetallesBinding
import com.example.t5_navegacion.model.Producto

class DetallesFragment: Fragment() {
    private lateinit var binding: FragmentDetallesBinding
    private lateinit var adapterProductos: AdapterProductos

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapterProductos = AdapterProductos(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetallesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getProducts()
    }

    private fun getProducts(){
        val peticion = JsonObjectRequest("https://dummyjson.com/products",{
            val products = it.getJSONArray("products")
            for (i in 0 until products.length()){
                val item = products.getJSONObject(i)
                val itemProducto = Producto(item.getString("title"),item.getDouble("price"),item.getString("description"),item.getString("category"),item.getString("thumbnail"))
                adapterProductos.addProducto(itemProducto)
            }
        },{})
        Volley.newRequestQueue(context).add(peticion)
    }
    fun getActualProduct(producto: Producto){
        val peticion = JsonObjectRequest("https://dummyjson.com/products",{
            val products = it.getJSONArray("products")
            for (i in 0 until products.length()){
                val item = products.getJSONObject(i)
                if (producto.nombre == item.getString("title")){
                    binding.nombreText.text = producto.nombre
                }
            }
        },{})
        Volley.newRequestQueue(context).add(peticion)
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }

}