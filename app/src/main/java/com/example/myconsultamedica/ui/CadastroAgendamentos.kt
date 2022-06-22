package com.example.myconsultamedica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myconsultamedica.R
import com.example.myconsultamedica.ui.model.AgendamentoConsultaModel
import com.example.myconsultamedica.ui.model.MedicosModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadastroAgendamentos : AppCompatActivity() {

    private lateinit var dbRefb :DatabaseReference

     fun onCreate( agendamentos: AgendamentoConsultaModel) {
        Log.d("DEBUG","MED BEFORE CREATE")

        Log.d("DEBUG","MED AFTER CREATE")

        Log.d("DEBUG","PAREI AQUI")


        dbRefb = FirebaseDatabase.getInstance().getReference("AdendamentosConsultas")

        val medId = dbRefb.push().key!!

         dbRefb.child(medId).setValue(agendamentos)
            .addOnCompleteListener {
                Toast.makeText(this, "Dados salvo com sucesso", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{err ->
                Toast.makeText(this, "Flaha ${err.message}", Toast.LENGTH_LONG).show()
            }

    }
}