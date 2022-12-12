package com.example.registroalumnos.BadeDeDatos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "alumnos")
class Alumnos (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String = "",
    val apellidos: String = "",
    val curso: String = ""

)