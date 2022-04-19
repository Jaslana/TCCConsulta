package com.example.myconsultamedica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Consultas_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultas_medico)

        val cadConsultaClick = findViewById<TextView>(R.id.txt_cadastrar_consulta)
        cadConsultaClick.setOnClickListener {
            val intentMedCadConsulta = Intent(this, Cadastro_consulta_medico::class.java)
            startActivity(intentMedCadConsulta)
        }

    }
}