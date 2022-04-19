package com.example.myconsultamedica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Cadastro_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("DEBUG","MED BEFORE CREATE")
        super.onCreate(savedInstanceState)
        Log.d("DEBUG","MED AFTER CREATE")
        setContentView(R.layout.activity_cadastro_medico)

        Log.d("DEBUG","PAREI AQUI")
    }
}