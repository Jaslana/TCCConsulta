package com.example.myconsultamedica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.example.myconsultamedica.ui.subcriber.Cadastro_medico
import com.example.myconsultamedica.ui.subcriber.Cadastro_paciente
import com.example.myconsultamedica.ui.subcriber.Principal_medico
import com.example.myconsultamedica.ui.subcriber.Principal_paciente

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btMedico = findViewById<RadioButton>(R.id.rb_medico)
        val btPaciente = findViewById<RadioButton>(R.id.rb_paciente)
        val cadastroClick = findViewById<TextView>(R.id.txt_cadastrar_usuario)

        cadastroClick.setOnClickListener {
            Log.d("DEBUG","CLICK")
            if (btMedico.isChecked){
                Log.d("DEBUG","MEDICO")
                val intentMed = Intent(this, Cadastro_medico::class.java)
                startActivity(intentMed)
            }
            if(btPaciente.isChecked){
                Log.d("DEBUG","PACIENTE")
                val intentPac = Intent(this, Cadastro_paciente::class.java)
                startActivity(intentPac)
            }
        }

        val entrarClick = findViewById<Button>(R.id.btn_entrar_login)
        entrarClick.setOnClickListener {
            Log.d("DEBUG","CLICK")
            if (btMedico.isChecked){
                Log.d("DEBUG","MEDICO")
                val intentMed = Intent(this, Principal_medico::class.java)
                startActivity(intentMed)
            }
            if(btPaciente.isChecked){
                Log.d("DEBUG","PACIENTE")
                val intentPac = Intent(this, Principal_paciente::class.java)
                startActivity(intentPac)
            }
        }

    }



}