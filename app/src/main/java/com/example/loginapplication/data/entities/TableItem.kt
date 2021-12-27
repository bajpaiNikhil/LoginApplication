package com.example.loginapplication.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "authenticationTable")
data class TableItem (

    @ColumnInfo(name = "userName")
    var name : String,

    @ColumnInfo(name = "userEmail")
    var email : String,

    @ColumnInfo(name  = "userPassword")
    var password : String ,

    @ColumnInfo(name = "phoneNumber")
    var phNumber : String ,

    @ColumnInfo(name = "userAddress")
    var address : String ,

    ){

    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}