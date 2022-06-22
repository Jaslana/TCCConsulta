package com.example.myconsultamedica.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

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