package com.example.myconsultamedica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myconsultamedica.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadastroConsultaMedico : AppCompatActivity() {

    private lateinit var edtDataConultaMedico : EditText
    private lateinit var edtHoraConultaMedico : EditText
    private lateinit var edtTempoConultaMedico : EditText
    private lateinit var edtStatusConultaMedico : EditText
    private lateinit var edtConveConultaMedico : EditText
    private lateinit var edtValorConultaMedico : EditText
    private lateinit var edtValorNaoConultaMedico : CheckBox
    private lateinit var btnSalvarConultaMedico : Button

    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_consulta_medico)

        val spinnerConsultaStatus = findViewById<Spinner>(R.id.spinner_cadastro_consulta_status)
        ArrayAdapter.createFromResource(this, R.array.status_consulta,android.R.layout.simple_spinner_item)
            .also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerConsultaStatus.adapter = adapter
        }

        val spinnerConsultaConvenio = findViewById<Spinner>(R.id.spinner_cadastro_consulta_convenios)
        ArrayAdapter.createFromResource(this, R.array.convenios_consulta,android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerConsultaConvenio.adapter = adapter
            }

        edtDataConultaMedico = findViewById(R.id.editText_data_consulta)
        edtHoraConultaMedico = findViewById(R.id.editText_hora_consulta)
        edtTempoConultaMedico = findViewById(R.id.editText_duracao_consulta)
        edtStatusConultaMedico = findViewById(R.id.spinner_cadastro_consulta_status)
        edtConveConultaMedico = findViewById(R.id.spinner_cadastro_consulta_convenios)
        edtValorConultaMedico = findViewById(R.id.editText_cadastro_consulta_valor)
        edtValorNaoConultaMedico = findViewById(R.id.checkbox_valor_nao_se_aplica)
        btnSalvarConultaMedico = findViewById(R.id.btn_medico_cadastrar)

        dbRef = FirebaseDatabase.getInstance().getReference("ConsultaMedicas")

        btnSalvarConultaMedico.setOnClickListener{
            saveConsultaMedicaData()
        }


    }

    private fun saveConsultaMedicaData() {
        val consMedData = edtDataConultaMedico.text.toString()
        val consMedHora = edtHoraConultaMedico.text.toString()
        val consMedTempo = edtTempoConultaMedico.text.toString()
        val consMedStatus = edtStatusConultaMedico.text.toString()
        val consMedConve = edtConveConultaMedico.text.toString()
        val consMedValor = edtValorConultaMedico.text.toString()
        val consMedValorNao = edtValorNaoConultaMedico.text.toString()

        if (consMedData.isEmpty()){
            edtDataConultaMedico.error = "Por favor insira A Data da Consulta"
        }
        if (consMedHora.isEmpty()){
            edtHoraConultaMedico.error = "Por favor insira a Hora da Consulta"
        }
        if (consMedTempo.isEmpty()){
            edtTempoConultaMedico.error = "Por favor insira o Tempo da Consulta"
        }
        if (consMedStatus.isEmpty()){
            edtStatusConultaMedico.error = "Por favor insira verefique o status"
        }
        if (consMedConve.isEmpty()){
            edtConveConultaMedico.error = "Por favor insira verefique o convenio"
        }

        val consMedId = dbRef.push().key!!

        val consultasMedicas = ConsultaMedicasModel(consMedId, consMedData, consMedHora, consMedTempo, consMedStatus, consMedConve, consMedValor, consMedValorNao)

        dbRef.child(consMedId).setValue(consultasMedicas)
            .addOnCanceledListener {
                Toast.makeText(this, "Dados salvo com sucesso", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{err ->
                Toast.makeText(this, "Flaha ${err.message}", Toast.LENGTH_LONG).show()
            }

    }
}