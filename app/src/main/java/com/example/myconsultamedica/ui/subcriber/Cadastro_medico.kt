package com.example.myconsultamedica.ui.subcriber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myconsultamedica.R

class Cadastro_medico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("DEBUG","MED BEFORE CREATE")
        super.onCreate(savedInstanceState)
        Log.d("DEBUG","MED AFTER CREATE")
        supportActionBar?.hide()
        setContentView(R.layout.activity_cadastro_medico)

        Log.d("DEBUG","PAREI AQUI")
    }
}