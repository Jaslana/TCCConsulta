package com.example.myconsultamedica.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myconsultamedica.data.db.dao.MedicosDao
import com.example.myconsultamedica.data.db.entity.MedicosEntity

@Database(entities = [MedicosEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract val consultaDao: MedicosDao

    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            synchronized(this) {
                var instance: AppDataBase? = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDataBase::class.java,
                        "app_database"
                    ).build()
                }

                return instance
            }
        }
    }
}