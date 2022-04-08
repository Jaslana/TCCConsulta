package com.example.myconsultamedica.repository

import androidx.lifecycle.LiveData
import com.example.myconsultamedica.data.db.entity.MedicosEntity

interface MedicoRepository {

    suspend fun insertMedicos(name: String, profissao:String, crm:String, endereco:String,
                              numeroEnd: String, bairro: String, cidade:String, estado: String,
                              cep:String, celular:String, email:String, senha:String, senhaconf:String): Long

    suspend fun updateMedicos(name: String, profissao:String, crm:String, endereco:String,
                              numeroEnd: String, bairro: String, cidade:String, estado: String,
                              cep:String, celular:String, email:String, senha:String, senhaconf:String)

    suspend fun deleteMedicos(crm: String)

    suspend fun deleteAllMedicos()

    suspend fun getAllMedicos(): LiveData<List<MedicosEntity>>
}