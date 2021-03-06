package com.example.myconsultamedica.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.myconsultamedica.R

class PrincipalPaciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_paciente)

        val dadosClick = findViewById<TextView>(R.id.txt_meus_dados)
        dadosClick.setOnClickListener {
            val intentPacDados = Intent(this, DadosPaciente::class.java)
            startActivity(intentPacDados)
        }

        val consultasClick = findViewById<TextView>(R.id.txt_consultas)
        consultasClick.setOnClickListener {
            val intentPacConsultas = Intent(this, ConsultasPaciente::class.java)
            startActivity(intentPacConsultas)
        }

        val agendamentosClick = findViewById<TextView>(R.id.txt_agendamentos)
        agendamentosClick.setOnClickListener {
            val intentPacAgendamentos = Intent(this, AgendamentosPaciente::class.java)
            startActivity(intentPacAgendamentos)
        }
    }
}