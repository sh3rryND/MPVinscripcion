package com.example.mpvinscripcion

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        val txvNombre = findViewById<TextView>(R.id.txvNombre)
        val txvCarrera = findViewById<TextView>(R.id.txvCarrera)
        val txvPromedio = findViewById<TextView>(R.id.txvPromedio)
        val txvTotal = findViewById<TextView>(R.id.txvTotal)

        val bundle = intent

        val nombre = bundle.getStringExtra("nombre")
        val carrera = bundle.getStringExtra("carrera")
        val promedio = bundle.getFloatExtra("promedio",0f)
        val totalPago = bundle.getFloatExtra("resultado",0f)
        txvNombre.text = nombre
        txvCarrera.text = carrera
        txvPromedio.text = promedio.toString()
        txvTotal.text = totalPago.toString()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}