package com.example.t3listas_json.ui.dialog.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request.Method
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.t3_listaapi.adapter.UsuarioAdapter
import com.example.t3_listajson.databinding.ActivityMainBinding
import com.example.t3_listajson.model.User
import com.example.t3listas_json.R
import com.example.t3listas_json.databinding.ActivityMainBinding
import com.example.t3listas_json.model.User
import org.json.JSONObject

class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    private lateinit var listaUsuario: ArrayList<User>;
    private lateinit var adaptadoUsuariosAdapter: UsuarioAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listaUsuario = ArrayList();
        adaptadoUsuariosAdapter = UsuarioAdapter(listaUsuario, this)

        binding.recyclerUsuarios.adapter = adaptadoUsuariosAdapter;
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        // creo la peticion
        val url = "https://randomuser.me/api/?results=50"
        val peticion: JsonObjectRequest = JsonObjectRequest(url, {
            getUsers(it)
        }, {

        })
        //val peticion2: JsonObjectRequest = JsonObjectRequest(Method.GET,url,null,{},{})
        // lanzar la peticion
        Volley.newRequestQueue(applicationContext).add(peticion)
    }

    override fun onStart() {
        super.onStart()
        binding.spinnerResultados.onItemSelectedListener = this
        binding.spinnerGenero.onItemSelectedListener = this
    }
    fun getUsers(response: JSONObject): Unit {
        // crear clase modelo User
        // obtener una lista de todos los usuarios del JSON
        val results = response.getJSONArray("results")
        for (i in (0..results.length() - 1)) {
            val user = results.getJSONObject(i);
            val name = user.getJSONObject("name").getString("first")
            val last = user.getJSONObject("name").getString("last")
            val phone = user.getString("phone");
            val email = user.getString("email");
            val image = user.getJSONObject("picture").getString("medium")
            val country = user.getJSONObject("location").getString("country")

            val city = user.getJSONObject("location").getString("city")
            val usuario = User(name, last, email, phone, country, city, image)
            listaUsuario.add(
                usuario
            )
            adaptadoUsuariosAdapter.notifyItemInserted(listaUsuario.size-1)
        }
        // nombre, apellido, telefono, pais, ciudad, codigo postal, mail

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_reset->{
                binding.spinnerResultados.setSelection(49)
                binding.spinnerGenero.setSelection(0)
            }
            R.id.menu_version->{
                val versionDialog:VersionDialog = VersionDialog()
                versionDialog.show(supportFragmentManager,"")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when(parent!!.id){
            binding.spinnerResultados.id->{

            }
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}