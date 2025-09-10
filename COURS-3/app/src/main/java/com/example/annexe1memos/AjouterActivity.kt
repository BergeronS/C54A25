package com.example.annexe1memos

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.DatePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AjouterActivity : AppCompatActivity() {

    lateinit var boutonDate:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ajouter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    inner class Ecouteur : OnClickListener, OnDateSetListener {
        override fun onClick(v: View?) {
            if (v == boutonDate) {
                val d = DatePickerDialog(this@AjouterActivity)
                d.setOnDateSetListener(this)
                // on veut lafficher
                d.show()
            }
            else { // bouton ajouter
                // creer un objet memo et ajouter le memo dans la liste du singleton
                SingletonMemos.ajouterMemo(Memo (champMemo.text.toString(), dateChoisie))
                SingletonMemos.serialiserListe(this@AjouterActivity)  // le fichier va etre dans device manager/data/data/nom package/files/serialisation.ser
                champMemo.text.clear()
                champText.text = ""
            // lajouter a notre liste

                finish()
            }
        }

        override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
            // aller chercher le message et le localdate

            dateChoisie = LocalDate.of(year, month+1, dayOfMonth)


            // afficher la date dans le textview
            champDate.setText(dateChoisie.toString())
        }
    }
}