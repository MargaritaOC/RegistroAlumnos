package com.example.registroalumnos

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.registroalumnos.BadeDeDatos.Alumnos
import com.example.registroalumnos.BadeDeDatos.ListaAlumnos.Companion.database
import com.example.registroalumnos.databinding.ActivityMainBinding
import com.example.registroalumnos.menu.MenuActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : MenuActivity() {
    private lateinit var bindingMain : ActivityMainBinding

    lateinit var listaAlumnos: MutableList<Alumnos>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMain.root)
        listaAlumnos = ArrayList()


        // Evento click del botón añadir alumno
        bindingMain.AnadirAlumno.setOnClickListener {


            var nombreAlumno = bindingMain.Nombre.text.toString()
            var apellidosAlumno = bindingMain.Apellidos.text.toString()
            var curso = bindingMain.Curso.text.toString()



            if (nombreAlumno.isEmpty() || apellidosAlumno.isEmpty() || curso.isEmpty()) {
                Toast.makeText(this, "No puede haber campos vacíos", Toast.LENGTH_SHORT).show()
            } else {

                var alumno = Alumnos(nombre = nombreAlumno, apellidos = apellidosAlumno, curso = curso)

                listaAlumnos.add(alumno)
                anadirAlumno(alumno)
                Toast.makeText(this, "Alumno añadido", Toast.LENGTH_SHORT).show()


                limpiar()


                cerrarTeclado()

            }

        }

    }

    fun anadirAlumno(alumno: Alumnos) {

        CoroutineScope(Dispatchers.IO).launch {
            database.ListaDAO().insertarAlumnos(alumno)
        }
    }


    fun cerrarTeclado() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(bindingMain.root.windowToken, 0)
    }


    fun limpiar() {
        bindingMain.Nombre.text.clear()
        bindingMain.Apellidos.text.clear()
        bindingMain.Curso.text.clear()
    }

}