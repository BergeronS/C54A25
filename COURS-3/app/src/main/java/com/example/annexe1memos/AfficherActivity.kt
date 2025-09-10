package com.example.annexe1memos

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.FileNotFoundException

class AfficherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_afficher)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // attention fileNotFoundException
    fun lireMemos(): ArrayList<String>? {
        var v :ArrayList<Memo>? = null
        var triee :ArrayList<String>? = null
        try {
            v = SingletonMemos.recupererListe(this@AfficherActivity) // liste de memo qui vient du singleton
            v.sortWith(compareBy{it.echeance}) // it fait chaque objet plein de question dexamen ici la...
            triee = ArrayList<String>() // liste de strings vide
            for (memo in v) // pour chaque memo dans la liste
                triee.add(memo.message) // ajoute seulements les messages des memos
        } catch (f:FileNotFoundException) {
            Toast.makeText(this@AfficherActivity, "pas de fichier de serialisation", Toast.LENGTH_LONG).show()
            finish()
        }


        return triee
    }


}