package com.example.myconsultamedica.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import com.example.myconsultamedica.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class CadastroConsultaMedico : AppCompatActivity() {

    private lateinit var edtDataConsultaMedico : EditText
    private lateinit var edtHoraConsultaMedico : EditText
    private lateinit var edtTempoConsultaMedico : EditText
    private lateinit var edtStatusConsultaMeico : Spinner
    private lateinit var edtConvenioConsultaMedico : Spinner
    private lateinit var edtValorConsultaMedico : EditText
    private lateinit var edtValorNaoConsultaMedico : CheckBox
    private lateinit var btnSalvarConsultaMedico : Button

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

        edtDataConsultaMedico = findViewById(R.id.editText_data_consulta)
        edtHoraConsultaMedico = findViewById(R.id.editText_hora_consulta)
        edtTempoConsultaMedico = findViewById(R.id.editText_duracao_consulta)
        edtStatusConsultaMeico = findViewById(R.id.spinner_cadastro_consulta_status)
        edtConvenioConsultaMedico = findViewById(R.id.spinner_cadastro_consulta_convenios)
        edtValorConsultaMedico = findViewById(R.id.editText_cadastro_consulta_valor)
        edtValorNaoConsultaMedico = findViewById(R.id.checkbox_valor_nao_se_aplica)
        btnSalvarConsultaMedico = findViewById(R.id.btn_medico_cadastrar)

        dbRef = FirebaseDatabase.getInstance().getReference("ConsultasMedicas")

        btnSalvarConsultaMedico.setOnClickListener{

            salveConsultaMedicosData()
        }

    }

    private fun salveConsultaMedicosData() {

        val consMedData = edtDataConsultaMedico.text.toString()
        val consMedHora = edtHoraConsultaMedico.text.toString()
        val consMedTempo = edtTempoConsultaMedico.text.toString()
        val consMedStatus = edtStatusConsultaMeico.selectedItem.toString()
        val consMedConvenio = edtConvenioConsultaMedico.selectedItem.toString()
        val consMedValor = edtValorConsultaMedico.text.toString()
        val consMedValorNao = edtValorNaoConsultaMedico.isChecked.toString()

        if (consMedData.isEmpty()){
            edtDataConsultaMedico.error = "Por favor insira a Data"
        }
        if (consMedHora.isEmpty()){
            edtHoraConsultaMedico.error = "Por favor insira a Hora"
        }
        if (consMedTempo.isEmpty()){
            edtTempoConsultaMedico.error = "Por favor insira o tempo"
        }

        val consMedId = dbRef.push().key!!

        val consultasMedicas = ConsultaMedicasModel(consMedId, consMedData, consMedHora, consMedTempo, consMedStatus, consMedConvenio, consMedValor, consMedValorNao)

        dbRef.child(consMedId).setValue(consultasMedicas)
            .addOnCompleteListener {
                Toast.makeText(this, "Dados salvo com sucesso", Toast.LENGTH_LONG).show()
            }.addOnFailureListener{err ->
                Toast.makeText(this, "Flaha ${err.message}", Toast.LENGTH_LONG).show()
            }
    }
}