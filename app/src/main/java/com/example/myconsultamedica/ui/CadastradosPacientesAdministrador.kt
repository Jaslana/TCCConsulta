package com.example.myconsultamedica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myconsultamedica.R

class CadastradosPacientesAdministrador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrados_pacientes_administrador)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.rv_pacientes_cadastrados)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ViewModelPacientesCadastrados>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..21) {
            data.add(ViewModelPacientesCadastrados("Paciente " + i, "Data nascimento: 0"+i+"/01/2010","Telefone: (14)999999999",R.drawable.ic_baseline_edit_24,R.drawable.ic_baseline_delete_24))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = AdapterPacientesCadastrados(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }
}