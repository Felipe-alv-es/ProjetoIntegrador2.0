package com.example.aplicationtestinglayout.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "user_table")

class User (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val tituloTarefa: String,
    val descriTarefa: String,
    val dataTarefa: String,
    val horaTarefa: String

)


