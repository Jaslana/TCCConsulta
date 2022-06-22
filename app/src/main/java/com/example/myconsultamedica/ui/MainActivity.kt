package com.example.myconsultamedica.ui

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.myconsultamedica.R
import com.google.firebase.database.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        val btMedico = findViewById<RadioButton>(R.id.rb_medico)
        val btPaciente = findViewById<RadioButton>(R.id.rb_paciente)
        val cadastroClick = findViewById<TextView>(R.id.txt_cadastrar_usuario)
        val email = findViewById<EditText>(R.id.edit_text_email_login)
        val password = findViewById<EditText>(R.id.edit_text_senha_login)

        Firebase.auth.signOut()

        val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()

        cadastroClick.setOnClickListener {
            if (btMedico.isChecked){
                val intentMed = Intent(this, CadastroMedico::class.java)
                startActivity(intentMed)
            }
            if(btPaciente.isChecked){
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
    /**    val database = Firebase.database
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
    **/
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        //val currentUser = auth.currentUser
        //if(currentUser != null){
        //    reload();
        //}
    }

}