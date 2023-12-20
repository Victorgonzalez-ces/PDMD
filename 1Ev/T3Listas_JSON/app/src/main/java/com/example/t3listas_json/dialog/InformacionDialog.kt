package com.example.t3listas_json.dialog

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.t3listas_json.R

class InformacionDialog: DialogFragment() {
    private lateinit var context: Context
    private lateinit var vista: View
    private lateinit var textoComunicar: String
    private var edadComunicar: Int = 0
    private lateinit var texto: TextView
    companion object{
        fun newInstance(nombre: String): InformacionDialog{
            val informDialog: InformacionDialog = InformacionDialog()
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            informDialog.arguments = bundle
            //comienza el ciclo de vida
            return informDialog
        }
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        vista = LayoutInflater.from(context).inflate(R.layout.informacionusuario,null)
        textoComunicar = this.arguments?.getString("nombre") ?: "sin nombre"
        edadComunicar = this.arguments?.getInt("edad") ?: 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val builder = AlertDialog.Builder(context)
        builder.setView(vista)
        texto = vista.findViewById(R.id.textoInfo)
        texto.text = textoComunicar +" ${edadComunicar.toString()} "
        super.onCreate(savedInstanceState)

    }

    override fun onDetach() {
        super.onDetach()
    }
}