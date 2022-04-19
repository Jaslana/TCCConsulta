package com.example.myconsultamedica.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myconsultamedica.R

class Principal_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_medico)

        val dadosClick = findViewById<TextView>(R.id.txt_meus_dados)
        dadosClick.setOnClickListener {
                val intentMedDados = Intent(this, Dados_medico::class.java)
                startActivity(intentMedDados)
        }

        val consultasClick = findViewById<TextView>(R.id.txt_consultas)
        consultasClick.setOnClickListener {
            val intentMedConsultas = Intent(this, Consultas_medico::class.java)
            startActivity(intentMedConsultas)
        }

        val agendamentosClick = findViewById<TextView>(R.id.txt_agendamentos)
        agendamentosClick.setOnClickListener {
            val intentMedAgendamentos = Intent(this, Agendamentos_medico::class.java)
            startActivity(intentMedAgendamentos)
        }
    }
}