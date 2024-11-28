package com.example.timerpicker

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class TimePickerFragment(val listener: (String) -> Unit) : DialogFragment(), TimePickerDialog.OnTimeSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Obtener el calendario actual
        val calendar = Calendar.getInstance()
        val hora = calendar.get(Calendar.HOUR_OF_DAY)
        val minutos = calendar.get(Calendar.MINUTE)

        // Crear el TimePickerDialog
        val dialog = TimePickerDialog(requireContext(), this, hora, minutos, false)
        return dialog
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        // Crear un objeto Calendar para la hora seleccionada
        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hourOfDay)
            set(Calendar.MINUTE, minute)
        }

        // Formatear la hora a 12 horas (AM/PM)
        val timeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())  // Formato 12 horas con AM/PM
        val formattedTime = timeFormat.format(calendar.time)

        listener(formattedTime) // Pasar la hora formateada al listener
    }
}
