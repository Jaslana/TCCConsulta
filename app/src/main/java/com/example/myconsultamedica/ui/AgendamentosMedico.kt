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

    }

    private fun getAgenMedico() {
        recyclerview.visibility = View.GONE

        dbRef = FirebaseDatabase.getInstance().getReference("AdendamentosConsultas")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                data.clear()
                if(snapshot.exists()){
                    for (dataSnap in snapshot.children) {
                        val ageMedData = dataSnap.getValue(AgendamentoConsultaModel::class.java)
                        data.add(ageMedData!!)
                    }
                    val adapter = AdapterAgendamentosMedico(this@AgendamentosMedico,data)
                    recyclerview.adapter = adapter

                    recyclerview.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}