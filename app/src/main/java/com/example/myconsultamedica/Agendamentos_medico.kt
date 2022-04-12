package com.example.myconsultamedica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Agendamentos_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_agendamentos_medico)
    }
}