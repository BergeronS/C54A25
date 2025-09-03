package com.example.annexe1bclasse

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lireFichier()
    }

    fun lireFichier() : ArrayList<String> {
        val fis = openFileInput("texte.txt")
        var isr = InputStreamReader(fis)
        val br = BufferedReader(isr)
        var nbligne = 0
        var nbChar = 0
        var nbdeC = 0

        val a = ArrayList<String>()

        br.use {
            br.forEachLine { line -> a.add(line) }
        }

        a.forEach { ele -> println(ele) }

        a.forEach { ele -> nbligne++ }

        a.forEach { ele -> ele.forEach { nbChar++ } }

        println("nombre de ligne: " + nbligne)
        println("nombre de char: " + nbChar)
        return a
    }
}