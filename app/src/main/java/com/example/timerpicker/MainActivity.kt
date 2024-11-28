package com.example.timerpicker

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etTime: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etTime = findViewById(R.id.etTime)
        etTime.setOnClickListener { showTimePickerDialog() }
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment{time-> onTimeSelected(time)}
        timePicker.show(supportFragmentManager, "time")
    }

    private fun onTimeSelected(time: String) {
        etTime.setText("Has seleccionado las $time")
    }
}