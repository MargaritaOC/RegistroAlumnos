package com.example.registroalumnos.BadeDeDatos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Alumnos::class],
    version = 1
)

abstract class AlumnosBD : RoomDatabase(){
    abstract fun ListaDAO(): DAO
}