package com.example.t5_navegacion.ui.fragment

import android.content.Context
import android.os.Bundle
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
import org.json.JSONObject

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private lateinit var adapterProductos: AdapterProductos

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapterProductos = AdapterProductos(context)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Toda la parte gráfica esta asociada
        binding.textoUsuario.text = arguments?.getString("nombre")
        binding.recyclerProductos.adapter = adapterProductos
        binding.recyclerProductos.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        getAllProducts()

    }


    private fun getAllProducts():Unit{
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
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}