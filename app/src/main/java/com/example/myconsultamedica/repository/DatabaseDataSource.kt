package com.example.myconsultamedica.repository

import androidx.lifecycle.LiveData
import com.example.myconsultamedica.data.db.dao.MedicosDao
import com.example.myconsultamedica.data.db.entity.MedicosEntity

class DatabaseDataSource(
    private val medicoDao: MedicosDao
) : MedicoRepository {
    override suspend fun insertMedicos(
        name: String,
        profissao: String,
        crm: String,
        endereco: String,
        numeroEnd: String,
        bairro: String,
        cidade: String,
        estado: String,
        cep: String,
        celular: String,
        email: String,
        senha: String,
        senhaconf: String
    ): Long {

        val medios = MedicosEntity(
            name = name,
            profissao = profissao,
            crm = crm,
            endereco = endereco,
            numeroEnd = numeroEnd,
            bairro = bairro,
            cidade = cidade,
            estado = estado,
            cep = cep,
            celular = celular,
            email = email,
            senha = senha,
            senhaconf = senhaconf
        )

        return medicoDao.insert(medios)
    }

    override suspend fun updateMedicos(
        name: String,
        endereco: String,
        profissao: String,
        crm: String,
        numeroEnd: String,
        bairro: String,
        cidade: String,
        estado: String,
        cep: String,
        celular: String,
        email: String,
        senha: String,
        senhaconf: String
    ) {
        val medios = MedicosEntity(
            name = name,
            profissao = profissao,
            crm = crm,
            endereco = endereco,
            numeroEnd = numeroEnd,
            bairro = bairro,
            cidade = cidade,
            estado = estado,
            cep = cep,
            celular = celular,
            email = email,
            senha = senha,
            senhaconf = senhaconf
        )

        return medicoDao.update(medios)
    }

    override suspend fun deleteMedicos(crm: String) {
        medicoDao.delete(crm)
    }

    override suspend fun deleteAllMedicos() {
        medicoDao.deleteAll()
    }

    override suspend fun getAllMedicos(): LiveData<List<MedicosEntity>> {
        return medicoDao.getAll()
    }
}