package com.example.loginapplication.repositories

import com.example.loginapplication.data.AuthenticationDatabase
import com.example.loginapplication.data.entities.TableItem

class AuthenticationRepo( private val db : AuthenticationDatabase ) {


    suspend fun upset(item:TableItem) = db.getAuthenticationDao().upset(item)

    fun getAllUserData() = db.getAuthenticationDao().checkUser()

}