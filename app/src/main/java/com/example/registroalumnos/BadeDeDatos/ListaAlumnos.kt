package com.example.registroalumnos.BadeDeDatos

import android.app.Application
import androidx.room.Room

class ListaAlumnos: Application() {
    companion object {
        lateinit var database: AlumnosBD
    }


    override fun onCreate() {
        super.onCreate()
        ListaAlumnos.database = Room.databaseBuilder(this, AlumnosBD::class.java, "Alumnos Data Base").build()
    }

}