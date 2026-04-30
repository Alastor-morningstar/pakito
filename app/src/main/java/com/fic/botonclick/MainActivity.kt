package com.fic.botonclick

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var contador = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val boton = findViewById<Button>(R.id.Boton)

        boton.setOnClickListener {
            contador++
            boton.text = contador.toString()
        }
        Log.d("Ciclo", "onCreate")
    }
    // 1. Guardamos el dato antes de que se destruya la pantalla
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("mi_contador", contador)
    }

    // 2. Recuperamos el dato al volver a crear la pantalla
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        contador = savedInstanceState.getInt("mi_contador")
        // IMPORTANTE: Actualiza el texto del botón para que se vea el cambio
        val boton = findViewById<Button>(R.id.Boton)
        boton.text = contador.toString()
    }
}
