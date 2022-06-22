package com.example.myconsultamedica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myconsultamedica.R
import com.example.myconsultamedica.ui.model.ConsultaMedicasModel
import com.google.firebase.database.*

class ConsultasPaciente : AppCompatActivity() {

    private lateinit var dbRef : DatabaseReference
    private lateinit var recyclerview : RecyclerView
    private lateinit var data: ArrayList<ConsultaMedicasModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultas_paciente)

        // getting the recyclerview by its id
        recyclerview = findViewById(R.id.rv_consultas_paciente)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
        // ArrayList of class ItemsViewModel
        data = arrayListOf<ConsultaMedicasModel>()
        // This will pass the ArrayList to our Adapter
//        val adapter = AdapterConsultasPaciente(data)

        // Setting the Adapter with the recyclerview
//        recyclerview.adapter = adapter
        getConsPacData()
        /**
        val editClick = findViewById<ImageButton>(R.id.rv_medicos_cadastrados)

        editClick.setOnClickListener {
        val intentDadosMed = Intent(this, Dados_medico::class.java)
        startActivity(intentDadosMed)
        }
         */
    }

    private fun getConsPacData() {
        recyclerview.visibility = View.GONE
        dbRef = FirebaseDatabase.getInstance().getReference("ConsultasMedicas")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                data.clear()
                if (snapshot.exists()) {
                    for (consPacSnap in snapshot.children) {
                        val consPacData =
                            consPacSnap.getValue(ConsultaMedicasModel::class.java)
                        data.add(consPacData!!)
                    }
                    val consPacAdapter = AdapterConsultasPaciente(data)
                    recyclerview.adapter = consPacAdapter

                    recyclerview.visibility = View.VISIBLE
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}