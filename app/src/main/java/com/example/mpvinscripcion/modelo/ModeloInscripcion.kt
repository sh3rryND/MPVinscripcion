package com.example.mpvinscripcion.modelo

import com.example.mpvinscripcion.contratos.ContratoInscrip

class ModeloInscripcion: ContratoInscrip.Modelo {

    override fun calcularPago(promedio: Float): Float
    {  val descuento: Float
       val montoBase: Float= 1000f
        val totalpago: Float
        if (promedio >= 9.5) {
            descuento = 0.4f
            val totaldes= montoBase* descuento
             totalpago= montoBase-totaldes
        } else if (promedio >= 8.5) {
            descuento = 0.2f
            val totaldes= montoBase* descuento
             totalpago= montoBase-totaldes
        } else {
            descuento = 0f
             totalpago= montoBase
        }
        return totalpago
    }
}