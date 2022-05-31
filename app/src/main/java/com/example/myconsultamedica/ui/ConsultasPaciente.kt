package com.example.myconsultamedica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myconsultamedica.R

class ConsultasPaciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultas_paciente)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.rv_consultas_paciente)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ViewModelConsultasPaciente>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..21) {
            data.add(ViewModelConsultasPaciente("Consulta " + i, "Dr "+i,"especialista" +i, "01/01/22","08:00",R.drawable.ic_baseline_assignment_24))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = AdapterConsultasPaciente(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        /**
        val editClick = findViewById<ImageButton>(R.id.rv_medicos_cadastrados)

        editClick.setOnClickListener {
        val intentDadosMed = Intent(this, Dados_medico::class.java)
        startActivity(intentDadosMed)
        }
         */
    }
}