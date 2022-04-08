package com.example.myconsultamedica.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myconsultamedica.data.db.entity.MedicosEntity

@Dao
interface MedicosDao {
    @Insert
    suspend fun insert(medicos: MedicosEntity): Long

    @Update
    suspend fun update(medicos: MedicosEntity)

    @Query("DELETE FROM Medicos WHERE crm = :crm")
    suspend fun delete(crm: String)

    @Query("DELETE FROM Medicos")
    suspend fun deleteAll()

    @Query("SELECT*FROM Medicos")
    fun getAll(): LiveData<List<MedicosEntity>>
}