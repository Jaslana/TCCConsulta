package com.example.myconsultamedica.ui

data class ViewModelConsultasPaciente(
    val consulta: String,
    val medico: String,
    val especialidade: String,
    val dataConsulta: String,
    val horaConsulta: String,
    val agendar: Int ){

}
