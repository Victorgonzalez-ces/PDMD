package com.example.t3listas_json.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.t3listas_json.R

class GeneroListaDialog: DialogFragment() {

    private var listener: onGeneroListaLister? = null
    private lateinit var context: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        listener = context as onGeneroListaLister
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setTitle("Por que genero quieres filtrar")
        builder.setItems(R.array.generos){_,posicion ->
            val genero = resources.getStringArray(R.array.generos)[posicion]
            Toast.makeText(this.context,genero,Toast.LENGTH_SHORT).show()
        }
        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    interface  onGeneroListaLister {
        fun onGeneroListaSelected(genero: String)
    }
}