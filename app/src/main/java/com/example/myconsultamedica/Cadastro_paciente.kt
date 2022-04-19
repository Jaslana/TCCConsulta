package com.example.myconsultamedica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Cadastro_paciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("DEBUG","PAC BEFORE CREATE")
        super.onCreate(savedInstanceState)
        Log.d("DEBUG","PAC AFTER CREATE")
        setContentView(R.layout.activity_cadastro_paciente)
    }
}