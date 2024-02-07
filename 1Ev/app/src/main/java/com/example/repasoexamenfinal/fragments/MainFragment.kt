package com.example.repasoexamenfinal.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.repasoexamenfinal.adapters.AdapterProductos
import com.example.repasoexamenfinal.databinding.FragmentMainBinding
import com.google.firebase.database.FirebaseDatabase
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.repasoexamenfinal.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapterProductos: AdapterProductos
    private lateinit var database: FirebaseDatabase
    private lateinit var uid:String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        uid = arguments?.getString("uid") ?: ""
        adapterProductos = AdapterProductos(context,uid)
        database = FirebaseDatabase.getInstance("https://vgp-ces-default-rtdb.europe-west1.firebasedatabase.app/")

    }


    // This property is only valid between onCreateView and
    // onDestroyView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.editNombre.text = arguments?.getString("nombre")
        binding.recyclerProductos.adapter = adapterProductos
        binding.recyclerProductos.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        //getAllProducts()

        getAllProductsFB()
    }

    private fun getAllProducts(){
        var peticion: JsonObjectRequest = JsonObjectRequest("https://dummyjson.com/products",{
            val productos = it.getJSONArray("products")
            for (i in 0 until productos.length()){
                val imagenes: ArrayList<String>? = ArrayList()
                imagenes!!.add("Imagen 1")
                imagenes!!.add("Imagen 2")
                imagenes!!.add("Imagen 3")
                imagenes!!.add("Imagen 4")

                val item = productos.getJSONObject(i)
                val itemProducto = Producto(item.getInt("id"),
                    item.getString("title"),
                    item.getDouble("price"),
                    item.getString("description"),
                    item.getString("category"),
                    item.getString("thumbnail"),
                    imagenes)
                adapterProductos.addProducto(itemProducto)
            }
        },{})
        Volley.newRequestQueue(context).add(peticion)
    }

    private fun getAllProductsFB(){
        database.getReference("datos").child("products").orderByChild("title")
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    adapterProductos.borrarLista()
                    snapshot.children.forEach {
                        val producto:Producto? = it.getValue(Producto::class.java)
                        adapterProductos.addProducto(producto)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}