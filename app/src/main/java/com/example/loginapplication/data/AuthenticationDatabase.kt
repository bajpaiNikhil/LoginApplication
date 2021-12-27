package com.example.loginapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.loginapplication.data.entities.TableItem


@Database(
    entities = [TableItem::class] ,
    version = 1
)
abstract class AuthenticationDatabase : RoomDatabase() {

    abstract fun getAuthenticationDao() : AuthenticationDao

    companion object{

        @Volatile
        private var instance : AuthenticationDatabase ? =null
        private var Lock = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(Lock){
            instance ?: createDatabase(context).also{
                instance = it
            }
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext ,
                AuthenticationDatabase::class.java  ,
            "AuthenticationDB.db").build()

    }
}