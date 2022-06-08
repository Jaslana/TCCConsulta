package com.example.myconsultamedica.ui

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import com.example.myconsultamedica.R
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btMedico = findViewById<RadioButton>(R.id.rb_medico)
        val btPaciente = findViewById<RadioButton>(R.id.rb_paciente)
        val cadastroClick = findViewById<TextView>(R.id.txt_cadastrar_usuario)
        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()

        cadastroClick.setOnClickListener {
            Log.d("DEBUG","CLICK")
            if (btMedico.isChecked){
                Log.d("DEBUG","MEDICO")
                val intentMed = Intent(this, CadastroMedico::class.java)
                startActivity(intentMed)
            }
            if(btPaciente.isChecked){
                Log.d("DEBUG","PACIENTE")
                val intentPac = Intent(this, CadastroPaciente::class.java)
                startActivity(intentPac)
            }
        }

        val entrarClick = findViewById<Button>(R.id.btn_entrar_login)
        entrarClick.setOnClickListener {
            Log.d("DEBUG","CLICK")
            if (btMedico.isChecked){
                Log.d("DEBUG","MEDICO")
                val intentMed = Intent(this, PrincipalMedico::class.java)
                startActivity(intentMed)
            }
            if(btPaciente.isChecked){
                Log.d("DEBUG","PACIENTE")
                val intentPac = Intent(this, PrincipalPaciente::class.java)
                startActivity(intentPac)
            }
        }
        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<String>()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

    }



}