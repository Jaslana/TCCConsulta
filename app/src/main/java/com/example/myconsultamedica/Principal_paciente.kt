package com.example.myconsultamedica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Principal_paciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_principal_paciente)

        val dadosClick = findViewById<TextView>(R.id.txt_meus_dados)
        dadosClick.setOnClickListener {
            val intentPacDados = Intent(this, Dados_paciente::class.java)
            startActivity(intentPacDados)
        }

        val consultasClick = findViewById<TextView>(R.id.txt_consultas)
        consultasClick.setOnClickListener {
            val intentPacConsultas = Intent(this, Consultas_paciente::class.java)
            startActivity(intentPacConsultas)
        }

        val agendamentosClick = findViewById<TextView>(R.id.txt_agendamentos)
        agendamentosClick.setOnClickListener {
            val intentPacAgendamentos = Intent(this, Agendamentos_paciente::class.java)
            startActivity(intentPacAgendamentos)
        }
    }
}