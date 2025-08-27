package com.example.annexe1classe

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.BufferedWriter
import java.io.OutputStreamWriter

class MainActivity2 : AppCompatActivity() {
    lateinit var boutonAjouterMemo:Button
    lateinit var champMemo : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ajouter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        boutonAjouterMemo = findViewById(R.id.boutonMemo)
        champMemo = findViewById(R.id.champTexte)

        // une interface fonctionnel.
        // OnClickListener c'est une interface
        // une interface avec 1 seule methode a implementer --> OnClick
        // quand vous voyez une interface avec une seul methode a implementer on appeller
        // sa une "interface fonctionnel". (Une interface avec seulement une seule methode)
        // On parle d'une interface fonctionnel pcq on peut utiliser un lambda pour simplifier sa mise en oeuvre.
        // implement OnClickListener... ensuite coder la methode OnClick, sa prend la source et on choisie
        // ce qu'on veut faire.
        // Vu que c'est une interface fonctionnel on peut associer la source avec ce qu'on va faire direct avec
        // une fleche.

        // late lamdba ou wtv. tu peux lenlever des parametres. Comme on avait juste une seul lambda
        // dans les parametres le {} devient le code qui fait juste run.

        // simplification extreme interface fonctionnel + lambda + lambda comme last param --> On va en reparler.
        boutonAjouterMemo.setOnClickListener{
            var texteMemo = champMemo.text.toString() // oublie pas de virer sa en string sinon c'est un edit texte ou jsp quoi
            // verifier si TexteMemo est vide
            if ( ! texteMemo.isEmpty())
            {
                // se referer au docx de l'annexe 1
                // fos pour file ouput stream
                // Jamais de new
                // ya plusieurs mode. "append" sa ajoute a la fin. Private c'est toujours au debut du fichier
                // faque tu override
                val fos = openFileOutput("fichier.txt", MODE_APPEND)
                // osw pour output stream writer
                val osw = OutputStreamWriter(fos) // on passe le output dans le writer en param.
                // sa nous prend TOUJOURS un buffer (bw pour buffer writer)
                val bw = BufferedWriter(osw) // tu pass ton writer dans le buffer

                // la methode pour ecrire dans un flux cest
                bw.write(texteMemo) // .write()
                // on change de ligne apres avoir ecrit
                bw.newLine() // .newLine()
                // on ferme avec .close()
                // le close appelle le flush et clean le buffer
                bw.close()

                // si une exception survient, on a pas de catch ou rien, les exception c'est different en kotlin.

                champMemo.text.clear() // on vide le champ texte ici.
                // champMemo.setText("")

                finish() // pour revenir au menu princpale


                // pour checker ta db sur ton emulateur tu vas sur Device manager a droite,
                // sur tes 3 petits points de ton device "open in device explorer"
                // tu cherche ton package dans la liste /data/data/nom du packages/files
                // tu vas trouver le fichier.txt
            }
        }
    }
}