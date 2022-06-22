package com.example.myconsultamedica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myconsultamedica.R
import com.example.myconsultamedica.ui.model.AgendamentoConsultaModel
import com.google.firebase.database.*

class AgendamentosMedico : AppCompatActivity() {

    private lateinit var recyclerview: RecyclerView
    private lateinit var data: ArrayList<AgendamentoConsultaModel>
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendamentos_medico)

        // getting the recyclerview by its id
        recyclerview = findViewById(R.id.rv_agendamentos_medico)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        recyclerview.setHasFixedSize(true)
        // ArrayList of class ItemsViewModel
        data = ArrayList<AgendamentoConsultaModel>()

        getAgenMedico()

        // This loop will create 20 Views containing
        // the image with the count of view
//        for (i in 1..21) {
//            data.add(ViewModelAgendamentosMedico("Consulta " + i, "Paciente " + i, "01/01/22","08:00", R.drawable.ic_baseline_edit_24))
//        }
//
//        // This will pass the ArrayList to our Adapter
        val adapter = AdapterAgendamentosMedico(this,data)
//
//        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        /**
        val editClick = findViewById<ImageButton>(R.id.rv_medicos_cadastrados)

        editClick.setOnClickListener {
        val intentDadosMed = Intent(this, Dados_medico::class.java)
        startActivity(intentDadosMed)
        }
         */
    }

    private fun getAgenMedico() {
        recyclerview.visibility = View.GONE

        dbRef = FirebaseDatabase.getInstance().getReference("Agendamentos")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                data.clear()
                if(snapshot.exists()){
                    for (dataSnap in snapshot.children) {
                        val ageMedData = dataSnap.getValue(AgendamentoConsultaModel::class.java)
                        data.add(ageMedData!!)
                    }
//                    val adapter = AdapterAgendamentosMedico(this,data)
//                    recyclerview.adapter = adapter
//
//                    recyclerview.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}