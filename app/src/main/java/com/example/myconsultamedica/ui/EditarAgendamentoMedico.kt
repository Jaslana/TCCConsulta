package com.example.myconsultamedica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.myconsultamedica.R

class EditarAgendamentoMedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_agendamento_medico)

        val agendData = intent
        val agendPaciente = agendData.getStringExtra("nomePaciente")
        //val editText = findViewById<EditText>(R.id.editText_nome_paciente_agendamento).apply {
        //    text = agendPaciente
        //}
    }
}