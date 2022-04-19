package com.example.myconsultamedica.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "medicos")
data class MedicosEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val profissao:String,
    var crm: String,
    val endereco: String,
    val numeroEnd: String,
    val bairro: String,
    val cidade: String,
    val estado: String,
    val cep: String,
    val celular: String,
    val email: String,
    val senha: String,
    val senhaconf: String
)