package com.example.aplicationtestinglayout.data

import android.widget.ImageView
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aplicationtestinglayout.R

@Entity (tableName = "user_table")

class User (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String,
    var description: String,
    var assignetTo: String,
    var dueDate: String,
    var status: String
)


