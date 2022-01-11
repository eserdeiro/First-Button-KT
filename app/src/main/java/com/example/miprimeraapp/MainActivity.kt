package com.example.miprimeraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

data class Cursos(val nombre: String, val url: String){

}

class MainActivity : AppCompatActivity() {
    val react = Cursos("react","google.com")
    val js = Cursos("js", "js.com")
    var cursoActual = react.copy()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonsito = findViewById(R.id.boton) as Button

        botonsito.setOnClickListener{
            view -> whenClick(cursoActual)
            //tambien se puede hacer sin la lambda
            //verEnPantalla("Diste click ")
        }
    }

    fun verEnPantalla(s : String){
        val txt = findViewById(R.id.mensaje) as TextView
        txt.text = s
    }

    fun whenClick(curso : Cursos){
        cursoActual = curso.copy()
        when(curso.nombre) {
            "react" -> cursoActual = js.copy()
            "js" -> cursoActual = react.copy()
            else -> print("Esto nunca va a pasar")
        }
        verEnPantalla(s= "Curso de ${cursoActual.nombre} en ${cursoActual.url}")
    }
}