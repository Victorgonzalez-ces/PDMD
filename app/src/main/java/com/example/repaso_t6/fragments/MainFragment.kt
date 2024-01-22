package com.example.repaso_t6.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.repaso_t6.R
import com.example.repaso_t6.adapters.AdapterProductos
import com.example.repaso_t6.databinding.FragmentMainBinding
import com.example.repaso_t6.model.Producto

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MainFragment : Fragment() {


    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapterProductos: AdapterProductos

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapterProductos = AdapterProductos(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textoUsuario.text = arguments?.getString("nombre")
        binding.recyclerProductos.adapter = adapterProductos
        binding.recyclerProductos.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        getAllProducts()
    }

    private fun getAllProducts(){
        val peticion: JsonObjectRequest = JsonObjectRequest("https://dummyjson.com/products",{
            val productos = it.getJSONArray("products")
            for (i in 0 until productos.length()){
                val item = productos.getJSONObject(i)
                val itemProducto = Producto(
                    item.getString("title"),
                    item.getDouble("price"),
                    item.getString("description"),
                    item.getString("category"),
                    item.getString("thumbnail")
                )
                adapterProductos.addProducto(itemProducto)
            }
        },{})
        Volley.newRequestQueue(context).add(peticion)
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}