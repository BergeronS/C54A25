package com.example.annexe1memos

import android.content.Context
import java.io.ObjectOutputStream

object SingletonMemos {
    private var liste:ArrayList<Memo> = ArrayList()

    fun ajouterMemo ( memo:Memo)
    {
        liste.add(memo)
    }

    fun getList() : ArrayList<Memo> {
        return liste
    }


    fun serialiserListe(contexte: Context) {
        val fos = contexte.openFileOutput("serialisation.ser", Context.MODE_PRIVATE)
        val oos = ObjectOutputStream(fos) // cest un buffer, un tampon special pour les objects
        oos.use{oos.writeObject(liste)}
    }
}