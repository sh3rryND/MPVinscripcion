package com.example.mpvinscripcion.contratos

interface ContratoInscrip {

    interface Vista
    {
        fun showRes(totalPago: Float)
        fun showError(msg: String)
    }
    interface Modelo
    {
        fun calcularPago(promedio: Float): Float
    }

    interface Presentador
    {
        fun calcularPago(promedio: Float)
    }
}