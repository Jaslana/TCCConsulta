package com.example.myconsultamedica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.myconsultamedica.R

class CadastroConsultaMedico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_consulta_medico)

        val spinnerConsultaStatus = findViewById<Spinner>(R.id.spinner_cadastro_consulta_status)
        ArrayAdapter.createFromResource(this, R.array.status_consulta,android.R.layout.simple_spinner_item)
            .also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerConsultaStatus.adapter = adapter
        }

        val spinnerConsultaConvenio = findViewById<Spinner>(R.id.spinner_cadastro_consulta_convenios)
        ArrayAdapter.createFromResource(this, R.array.convenios_consulta,android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerConsultaConvenio.adapter = adapter
            }
    }
}