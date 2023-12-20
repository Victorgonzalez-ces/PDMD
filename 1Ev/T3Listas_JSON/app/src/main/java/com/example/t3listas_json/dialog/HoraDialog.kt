package com.example.t3listas_json.dialog

import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Context
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class HoraDialog: DialogFragment() {

    private lateinit var context: Context
    private var horaActual: Int = 0
    private var minutosActual: Int = 0
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
        val calendar = calendar.get(Calendar.MINUTE)
        horaActual = calendar.get(Calendar.HOUR_OF_DAY)
        minutosActual = calendar.get(Calendar.MINUTE)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        return TimePickerDialog(context, context as OnTimeSetListener,1,30,true)
    }

    override fun onDetach() {
        super.onDetach()
    }
}