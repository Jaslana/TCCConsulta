package com.example.myconsultamedica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myconsultamedica.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadastroPaciente : AppCompatActivity() {

    private lateinit var edtNomePaciente: EditText
    private lateinit var edtDataNascPaciente: EditText
    private lateinit var edtFonePaciente: EditText
    private lateinit var edtCelPaciente: EditText
    private lateinit var edtEmailPaciente: EditText
    private lateinit var edtSenhaPaciente: EditText
    private lateinit var edtSenhaConfPaciente: EditText
    private lateinit var btnSalvarPaciente: Button

    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("DEBUG","PAC BEFORE CREATE")
        super.onCreate(savedInstanceState)
        Log.d("DEBUG","PAC AFTER CREATE")
        setContentView(R.layout.activity_cadastro_paciente)

        edtNomePaciente = findViewById(R.id.editText_paciente_nome)
        edtDataNascPaciente = findViewById(R.id.editText_paciente_data_nascimento)
        edtFonePaciente = findViewById(R.id.editText_paciente_telefone)
        edtCelPaciente = findViewById(R.id.editText_paciente_celular)
        edtEmailPaciente = findViewById(R.id.editText_paciente_email)
        edtSenhaPaciente = findViewById(R.id.editText_paciente_senha)
        edtSenhaConfPaciente = findViewById(R.id.editText_paciente_senha_confirm)
        btnSalvarPaciente = findViewById(R.id.btn_paciente_cadastrar)

        dbRef = FirebaseDatabase.getInstance().getReference("Pacientes")

        btnSalvarPaciente.setOnClickListener{
            savePacientesData()
        }
    }

    private fun savePacientesData() {
        val pacNome = edtNomePaciente.text.toString()
        val pacDataNasc = edtDataNascPaciente.text.toString()
        val pacFone = edtFonePaciente.text.toString()
        val pacCel = edtCelPaciente.text.toString()
        val pacEmail = edtEmailPaciente.text.toString()
        val pacSenha = edtSenhaPaciente.text.toString()
        val pacSenhaConf = edtSenhaConfPaciente.text.toString()

        if (pacNome.isEmpty()){
            edtNomePaciente.error = "Por favor insira o nome completo"
        }
        if (pacDataNasc.isEmpty()){
            edtDataNascPaciente.error = "Por favor insira a Data de Nascimento"
        }
        if (pacFone.isEmpty()){
            edtFonePaciente.error = "Por favor insira o Telefone"
        }
        if (pacCel.isEmpty()){
            edtCelPaciente.error = "Por favor insira o Celular"
        }
        if (pacEmail.isEmpty()){
            edtEmailPaciente.error = "Por favor insira o Email"
        }
        if (pacSenha.isEmpty()){
            edtSenhaPaciente.error = "Por favor insira a Senha"
        }
        if (pacSenhaConf.isEmpty()){
            edtSenhaConfPaciente.error = "Por favor confirme a senha"
        }

        val pacId = dbRef.push().key!!

        val  pacientes = PacientesModel(pacId, pacNome, pacDataNasc, pacFone, pacCel, pacEmail, pacSenha, pacSenhaConf)

        dbRef.child(pacId).setValue(pacientes)
            .addOnCompleteListener {
                Toast.makeText(this, "Dados salvo com sucesso", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{err ->
                Toast.makeText(this, "Falha ${err.message}", Toast.LENGTH_LONG).show()
            }
    }
}