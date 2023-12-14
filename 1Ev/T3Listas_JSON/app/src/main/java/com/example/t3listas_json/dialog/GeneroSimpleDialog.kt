package com.example.t3listas_json.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.t3listas_json.R

class GeneroSimpleDialog : DialogFragment() {

    private var listener: onGeneroSimpleLister? = null
    private lateinit var context: Context
    private var genero: String? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        listener = context as onGeneroSimpleLister
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this.context)
        builder.setSingleChoiceItems(R.array.generos,-1){_,pos ->
            genero = resources.getStringArray(R.array.generos)[pos]
        }
        builder.setPositiveButton("ok"){_,_ ->

        }
        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    interface  onGeneroSimpleLister {
        fun onGeneroSimpleSelected(genero: String?)
    }
}