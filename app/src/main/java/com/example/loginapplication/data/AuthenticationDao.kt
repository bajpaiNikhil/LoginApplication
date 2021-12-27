package com.example.loginapplication.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.loginapplication.data.entities.TableItem


@Dao
interface AuthenticationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upset(item : TableItem)

    @Delete
    suspend fun delete(item : TableItem)

    @Query("SELECT * FROM authenticationTable")
    fun checkUser() : LiveData<List<TableItem>>

}