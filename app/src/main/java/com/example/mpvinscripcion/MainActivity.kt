package com.example.mpvinscripcion

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mpvinscripcion.Presentador.PresentadorInscripcion
import com.example.mpvinscripcion.contratos.ContratoInscrip

class MainActivity : AppCompatActivity(), ContratoInscrip.Vista {
    private lateinit var presentador: ContratoInscrip.Presentador
    private lateinit var nombre: String
    private lateinit var carrera: String
    private var promedio: Float = 0f

    fun setPresentador(presentador: ContratoInscrip.Presentador) {
        this.presentador = presentador
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val btnIr = findViewById<Button>(R.id.btnIr)
        val txtNombre = findViewById<EditText>(R.id.Nombre)
        val txtMatricula = findViewById<EditText>(R.id.Matricula)
        val txtPromedio = findViewById<EditText>(R.id.Promedio)

        val spinner = findViewById<Spinner>(R.id.spnOpcion)
        val boton = findViewById<Button>(R.id.btnIr)
        val opciones = arrayOf("Tics", "Mecatronica", "Mecanica", "Contaduria")

        val adaptador = ArrayAdapter<String>(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            opciones
        )
        spinner.adapter = adaptador

        presentador = PresentadorInscripcion(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnIr.setOnClickListener {
            nombre = txtNombre.text.toString()
            val matricula = txtMatricula.text.toString()
            carrera = spinner.selectedItem.toString()
            val promedio = txtPromedio.text.toString().toFloat()
            presentador.calcularPago(promedio)
        }


    }

    override fun showRes(totalPago: Float) {
        val intent= Intent(this, MainActivity2::class.java)
        intent.putExtra("nombre",nombre)
        intent.putExtra("carrera",carrera)
        intent.putExtra("promedio", promedio)
        intent.putExtra("resultado",totalPago)
        startActivity(intent)
    }

    override fun showError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}