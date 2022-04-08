package com.example.myconsultamedica.ui.subcriber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myconsultamedica.R

class Dados_paciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_dados_paciente)
    }
}