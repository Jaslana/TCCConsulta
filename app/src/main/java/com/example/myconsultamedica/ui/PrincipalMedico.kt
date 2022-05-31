package com.example.myconsultamedica.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.myconsultamedica.R

class PrincipalMedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal_medico)

        val dadosClick = findViewById<TextView>(R.id.txt_meus_dados)
        dadosClick.setOnClickListener {
            val intentMedDados = Intent(this, DadosMedico::class.java)
            Log.d("DEBUG","tela1")
            startActivity(intentMedDados)
            Log.d("DEBUG","tela2")
        }

        val consultasClick = findViewById<TextView>(R.id.txt_consultas)
        consultasClick.setOnClickListener {
            val intentMedConsult = Intent(this, ConsultasMedico::class.java)
            Log.d("DEBUG","tela1")
            startActivity(intentMedConsult)
            Log.d("DEBUG","tela2")
        }

        val agendamentosClick = findViewById<TextView>(R.id.txt_agendamentos)
        agendamentosClick.setOnClickListener {
            val intentMedAgendamentos = Intent(this, AgendamentosMedico::class.java)
            startActivity(intentMedAgendamentos)
            Log.d("DEBUG","tela")
        }
    }
}