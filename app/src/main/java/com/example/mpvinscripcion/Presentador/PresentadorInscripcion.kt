package com.example.mpvinscripcion.Presentador

import com.example.mpvinscripcion.contratos.ContratoInscrip
import com.example.mpvinscripcion.modelo.ModeloInscripcion

class PresentadorInscripcion (private val vista: ContratoInscrip.Vista): ContratoInscrip.Presentador{

    private val modelo: ContratoInscrip.Modelo= ModeloInscripcion()

    override fun calcularPago(promedio: Float)
    {
        if (promedio > 0) {
            val montoFinal = modelo.calcularPago(promedio)
            vista.showRes(montoFinal)

        } else {
            vista.showError("dato no validoo")
        }
    }

    }
