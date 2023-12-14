package com.example.t3listas_json.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.t3listas_json.R

class NacionalidadDialog: DialogFragment() {
    private lateinit var context: Context
    private var listener: OnNacionalidadListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        listener = context as OnNacionalidadListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)

        builder.setTitle("Selecciona las nacionalidades a mostrar")
        builder.setMultiChoiceItems(R.array.nacionalidades,null){ _, which, isChecked ->
            //ejecuto
            val nacionalidad = resources.getStringArray(R.array.nacionalidades)[which]
            if (isChecked){
                lista
            }
        }
        builder.setPositiveButton("Ok"){_,_ ->
            //comunico

        }
        return builder.create()
    }

    override fun onDetach() {
        super.onDetach()
    }

    interface OnNacionalidadListener{
        fun onDialogoNacionalidadSelected(nacionalidades: ArrayList<String>)
    }
}