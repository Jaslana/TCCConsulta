package com.example.myconsultamedica.ui.model

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(foreignKeys = [
    ForeignKey(
        entity = PacientesModel::class,
        parentColumns = ["pacId"],
        childColumns = ["pacId"]),

    ForeignKey(
        entity = MedicosModel::class,
        parentColumns = ["medId"],
        childColumns = ["medId"])
])
data class AgendamentoConsultaModel (
    var consMedId: String? = null,
    var consMedData: String? = null,
    var consMedHora: String? = null,
    var consMedTempo: String? = null,
    var consMedStatus: String? = null,
    var consMedConvenio: String? = null,
    var consMedValor: String? = null,
    var consMedValorNao: String? = null,
    var medId: String? = null,
    var pacId: String? = null,
        )