package com.example.myconsultamedica.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

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