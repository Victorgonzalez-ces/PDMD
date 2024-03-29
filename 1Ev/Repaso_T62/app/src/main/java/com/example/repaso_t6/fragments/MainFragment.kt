package com.example.repaso_t6.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.repaso_t6.adapters.AdapterProductos
import com.example.repaso_t6.databinding.FragmentMainBinding
import com.example.repaso_t6.model.Producto
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MainFragment : Fragment() {

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapterProductos: AdapterProductos
    private lateinit var database: FirebaseDatabase
    val uid = arguments?.getString("uid")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val uid = arguments?.getString("uid")?: ""
        adapterProductos = AdapterProductos(context,uid)
        database = FirebaseDatabase.getInstance("https://vgp-ces-default-rtdb.europe-west1.firebasedatabase.app/")
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
        //getAllproducts()
        binding.botonEscuchar.setOnClickListener {
            val reference = database.getReference("datos").child("products")
            reference.addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val hijos = snapshot.children
                    hijos.forEach{
                        val producto = it.getValue(Producto::class.java)
                        adapterProductos.addProducto(producto!!)
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
        }
    }

    /*private fun getAllproducts(){
        val peticion:JsonObjectRequest = JsonObjectRequest("https://dummyjson.com/products",{
            val products = it.getJSONArray("products")
            for (i in 0 until products.length()){
                val item = products.getJSONObject(i)
                val itemProducto = Producto(
                    item.getInt("id"),
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
    }*/
    override fun onDestroyView() {
        super.onDestroyView()
    }
}