package com.example.myconsultamedica.ui.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

class Model {
    @Entity
    data class MedicosModel (
        @PrimaryKey var medId: String? = null,
        var medNome: String? = null,
        var medLoug: String? = null,
        var medNumCasa: String? = null,
        var medBairro: String? = null,
        var medCidade: String? = null,
        var medEstado: String? = null,
        var medCep: String? = null,
        var medFone: String? = null,
        var medCel: String? = null,
        var medEmail: String? = null,
        var medSenha: String? = null,
        var medSenhaConf: String? = null,
    )

    @Entity
    data class PacientesModel (

        @PrimaryKey var pacId: String? = null,
        var pacNome: String? = null,
        var pacDataNasc: String? = null,
        var pacFone: String? = null,
        var pacCel: String? = null,
        var pacEmail: String? = null,
        var pacSenha: String? = null,
        var pacSenhaConf: String? = null,

        )

    @Entity(foreignKeys = [
        ForeignKey(
            entity = MedicosModel::class,
            parentColumns = ["medId"],
            childColumns = ["medId"])
    ])
    data class ConsultaMedicasModel(
        var consMedId: String? = null,
        var consMedData: String? = null,
        var consMedHora: String? = null,
        var consMedTempo: String? = null,
        var consMedStatus: String? = null,
        var consMedConvenio: String? = null,
        var consMedValor: String? = null,
        var consMedValorNao: String? = null,
        var medId: String? = null,
        val agendado: Boolean,
    )

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
    data class AgendamentoConsultaModel  (
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

//    @Entity(foreignKeys = [
//        ForeignKey(
//            entity = PacientesModel::class,
//            parentColumns = ["pacId"],
//            childColumns = ["pacId"]),
//
//        ForeignKey(
//            entity = MedicosModel::class,
//            parentColumns = ["medId"],
//            childColumns = ["medId"])
//    ])
//    data class BotoesModel  (
//        val edit: Int,
//        val delete: Int,
//        val agendar: Int
//    )
}