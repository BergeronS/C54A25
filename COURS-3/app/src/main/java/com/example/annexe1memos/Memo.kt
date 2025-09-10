package com.example.annexe1memos

import java.io.Serializable
import java.time.LocalDate

data class Memo  (var message: String, var echeance: LocalDate) : Serializable {

}