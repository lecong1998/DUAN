package com.example.movieapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "User")
data class User(var username: String, var password: String, var fullname: String, var email: String ): Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var country: String? = ""
    var img: String? = ""
}