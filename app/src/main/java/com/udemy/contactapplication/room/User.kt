package com.udemy.contactapplication.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class User(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("user_id")
    val id:Int,

    @ColumnInfo("user_name")
    val name:String,

    @ColumnInfo("user_email")
    val email:String
)
