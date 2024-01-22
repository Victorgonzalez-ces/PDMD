package com.example.t3listas_json.ui.dialog.activity

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class VersionDialog: DialogFragment() {

    private lateinit var context: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        return builder.create()
    }
}