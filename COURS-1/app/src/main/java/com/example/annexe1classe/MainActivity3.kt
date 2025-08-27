package com.example.annexe1classe

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity.MODE_APPEND
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity3 : AppCompatActivity() {
    lateinit var goBack: Button
    lateinit var liste: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_afficher)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        goBack = findViewById(R.id.goBack)
        goBack.setOnClickListener{finish()}

        liste = findViewById(R.id.liste)
        // apapter sa prend 3 parametres
        // le contexte de la screen, 00, 00
        liste.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, lireMemos()))



    }

    // fonction ici
    // : retourne arrayliste de string
    fun lireMemos () : ArrayList<String> {
        // flux de donnees
        val fis = openFileInput("fichier.txt")
        var isr = InputStreamReader(fis)
        val br = BufferedReader(isr)

        val arrayListe = ArrayList<String>()


        // maniere de base
        var ligne = br.readLine()

        while ( ligne != null ) {
            arrayListe.add(ligne)
            ligne = br.readLine()
        }

        br.close()

        return arrayListe

        // essayer de simplifier la methode en 2 lignes...
    }
}