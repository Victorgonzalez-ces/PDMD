package com.example.t5_navegacion.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.t5_navegacion.R
import com.example.t5_navegacion.adapter.AdapterProductos
import com.example.t5_navegacion.databinding.FragmentMainBinding
import com.example.t5_navegacion.databinding.FragmentSigninBinding
import com.example.t5_navegacion.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONObject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {
    private lateinit var adapterProductos: AdapterProductos

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding: FragmentMainBinding
    private lateinit var database: FirebaseDatabase

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapterProductos = AdapterProductos(context)
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
        //Toda la parte gráfica esta asociada
        binding.textoUsuario.text = arguments?.getString("nombre")
        binding.recyclerProductos.adapter = adapterProductos
        binding.recyclerProductos.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        getAllProducts()
        database.getReference("nombre").setValue("Victor")
        database.getReference("nombre").setValue("Vero")
        database.getReference("nombre").setValue("Nico")

        binding.botonEscuchar.setOnClickListener {
            val reference = database.getReference("datos").child("products").orderByChild("title").equalTo(binding.editTitle.text.toString())
            /*reference.addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {

                }

                override fun onCancelled(error: DatabaseError) {

                }
            })*/
            reference.addListenerForSingleValueEvent(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()){
                        for (i in snapshot.children){
                            for (j in i.children){
                                if (j.key.toString() == "price"){
                                    j.ref.setValue(binding.editPrecio.text.toString())
                                }
                            }
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
    }


    private fun getAllProducts():Unit{
        /*val peticion = JsonObjectRequest("https://dummyjson.com/products",{
            val products = it.getJSONArray("products")
            for (i in 0 until products.length()){
                val item = products.getJSONObject(i)
                val itemProducto = Producto(item.getString("title"),item.getDouble("price"),item.getString("description"),item.getString("category"),item.getString("thumbnail"))
                adapterProductos.addProducto(itemProducto)

            }
        },{})
        Volley.newRequestQueue(context).add(peticion)
    }
    override fun onDestroyView() {
        super.onDestroyView()*/

        val referencia = database.getReference("datos").child("products").orderByChild("discountPercentage")
        referencia.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val hijos = snapshot.children
                adapterProductos.clearList()
                hijos.forEach {
                    val producto: Producto? = it.getValue(Producto::class.java)
                    adapterProductos.addProducto(producto)
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}