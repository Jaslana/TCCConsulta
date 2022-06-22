package com.example.myconsultamedica.ui.model

import android.widget.Button
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(foreignKeys = [
    ForeignKey(
        entity = MedicosModel::class,
        parentColumns = ["medId"],
        childColumns = ["medNome"])
])
data class ConsultaMedicasModel  (
    var consMedId: String? = null,
    var consMedData: String? = null,
    var consMedHora: String? = null,
    var consMedTempo: String? = null,
    var consMedStatus: String? = null,
    var consMedConvenio: String? = null,
    var consMedValor: String? = null,
    var consMedValorNao: String? = null,
    var medNome: String? = null,
    val agendado: Boolean = false,
    val botaoAgend: Int = 0,
    )
