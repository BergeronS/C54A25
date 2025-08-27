package com.example.annexe1classe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // 1
    // dire a kotlin qu'on va mettre des valeurs plus tard.
    lateinit var boutonAjouter:Button
    lateinit var boutonAfficher:Button
    lateinit var boutonQuitter:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 2
        // call pour associer tes affaires
        boutonAjouter = findViewById(R.id.boutonAjouter)
        boutonAfficher = findViewById(R.id.boutonAfficher)
        boutonQuitter = findViewById(R.id.boutonQuitter)

        // 3
        // 1ere ecouteur
        val ec = Ecouteur()

        // 4
        // Associer tes ecouteurs a ton stock.
        boutonAjouter.setOnClickListener(ec)
        boutonAfficher.setOnClickListener(ec)
        boutonQuitter.setOnClickListener(ec)
    }

    // 5
    // 3e etape class ecouteur
    // t'ecris  inner class Ecouteur : OnClickListener et apres tu hover et tu fais "implement"
    inner class Ecouteur : OnClickListener {
        // pas de @ ici. c'est juste override. On garde la meme forme qu'avant pour le source ici.
        override fun onClick(v: View?) {
            // on fait un when ici qui est comme switch
            when ( v ) {
                boutonQuitter -> finish()
                boutonAjouter -> {
                    // pour ton intent la nouvelle forme c'est ca ici
                    val i = Intent (this@MainActivity, MainActivity2::class.java)
                    startActivity(i)
                }
                boutonAfficher -> {
                    val i = Intent (this@MainActivity, MainActivity3::class.java)
                    startActivity(i)
                }
            }
        }
    }
}