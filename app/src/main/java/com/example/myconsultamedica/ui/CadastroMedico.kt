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

class CadastroMedico : AppCompatActivity() {

    private lateinit var edtNomeMedico : EditText
    private lateinit var edtLougradouroMedico : EditText
    private lateinit var edtNumeroCasaMedico : EditText
    private lateinit var edtBairroMedico : EditText
    private lateinit var edtCidadeMedico : EditText
    private lateinit var edtEstadoMedico : EditText
    private lateinit var edtCepMedico : EditText
    private lateinit var edtFoneMedico : EditText
    private lateinit var edtCelMedico : EditText
    private lateinit var edtEmailMedico : EditText
    private lateinit var edtSenhaMedico : EditText
    private lateinit var edtSenhaConfMedico : EditText
    private lateinit var btnSalvarMedico : Button

    private lateinit var dbRefb :DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("DEBUG","MED BEFORE CREATE")
        super.onCreate(savedInstanceState)
        Log.d("DEBUG","MED AFTER CREATE")
        setContentView(R.layout.activity_cadastro_medico)

        Log.d("DEBUG","PAREI AQUI")

        edtNomeMedico = findViewById(R.id.editText_medico_nome)
        edtLougradouroMedico = findViewById(R.id.editText_medico_logradouro)
        edtNumeroCasaMedico = findViewById(R.id.editText_medico_end_numero)
        edtBairroMedico = findViewById(R.id.editText_medico_bairro)
        edtCidadeMedico = findViewById(R.id.editText_medico_cidade)
        edtEstadoMedico = findViewById(R.id.editText_medico_estado)
        edtCepMedico = findViewById(R.id.editText_medico_cep)
        edtFoneMedico = findViewById(R.id.editText_medico_telefone)
        edtCelMedico = findViewById(R.id.editText_medico_celular)
        edtEmailMedico = findViewById(R.id.editText_medico_email)
        edtSenhaMedico = findViewById(R.id.editText_medico_senha)
        edtSenhaConfMedico = findViewById(R.id.editText_medico_senha_confirm)
        btnSalvarMedico = findViewById(R.id.btn_medico_cadastrar)

        dbRefb = FirebaseDatabase.getInstance().getReference("Medicos")

        btnSalvarMedico.setOnClickListener{
            saveMedicosData()
        }
    }

    private fun saveMedicosData() {

        val medNome = edtNomeMedico.text.toString()
        val medLoug = edtLougradouroMedico.text.toString()
        val medNumCasa = edtNumeroCasaMedico.text.toString()
        val medBairro = edtBairroMedico.text.toString()
        val medCidade = edtCidadeMedico.text.toString()
        val medEstado = edtEstadoMedico.text.toString()
        val medCep = edtCepMedico.text.toString()
        val medFone = edtFoneMedico.text.toString()
        val medCel = edtCelMedico.text.toString()
        val medEmail = edtEmailMedico.text.toString()
        val medSenha = edtSenhaMedico.text.toString()
        val medSenhaConf = edtSenhaConfMedico.text.toString()

        if (medNome.isEmpty()){
            edtNomeMedico.error = "Por favor insira o nome completo"
        }
        if (medLoug.isEmpty()){
            edtLougradouroMedico.error = "Por favor insira o Lougradouro"
        }
        if (medNumCasa.isEmpty()){
            edtNumeroCasaMedico.error = "Por favor insira o Numero da Casa"
        }
        if (medBairro.isEmpty()){
            edtBairroMedico.error = "Por favor insira o Bairro"
        }
        if (medCidade.isEmpty()){
            edtCidadeMedico.error = "Por favor insira a Cidade"
        }
        if (medEstado.isEmpty()){
            edtEstadoMedico.error = "Por favor insira o Estado"
        }
        if (medCep.isEmpty()){
            edtCepMedico.error = "Por favor insira o CEP"
        }
        if (medFone.isEmpty()){
            edtFoneMedico.error = "Por favor insira o telefone"
        }
        if (medCel.isEmpty()){
            edtCelMedico.error = "Por favor insira o celular"
        }
        if (medEmail.isEmpty()){
            edtEmailMedico.error = "Por favor insira o email"
        }
        if (medSenha.isEmpty()){
            edtSenhaMedico.error = "Por favor insira a senha"
        }
        if (medSenhaConf.isEmpty()){
            edtSenhaConfMedico.error = "Por favor confirme a senha"
        }

        val medId = dbRefb.push().key!!

        val medicos = MedicosModel(medId, medNome, medLoug, medNumCasa, medBairro, medCidade, medEstado, medCep, medFone, medCel, medEmail, medSenha, medSenhaConf)

        dbRefb.child(medId).setValue(medicos)
            .addOnCanceledListener {
                Toast.makeText(this, "Dados salvo com sucesso", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{err ->
                Toast.makeText(this, "Flaha ${err.message}", Toast.LENGTH_LONG).show()
            }
    }
}