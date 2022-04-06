package com.example.myconsultamedica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class Principal_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_principal_medico)

        val dadosClick = findViewById<TextView>(R.id.txt_meus_dados)
        dadosClick.setOnClickListener {
                val intentMed = Intent(this, Dados_medico::class.java)
                startActivity(intentMed)
        }
    }
}