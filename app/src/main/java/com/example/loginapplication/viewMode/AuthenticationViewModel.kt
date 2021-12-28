package com.example.loginapplication.viewMode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapplication.data.entities.TableItem
import com.example.loginapplication.repositories.AuthenticationRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AuthenticationViewModel( private val repository : AuthenticationRepo) : ViewModel() {

//    fun upset(item : TableItem) = CoroutineScope(Dispatchers.IO).launch {
//        repository.upset(item)
//    }

    fun upset(item: TableItem){
        viewModelScope.launch {
            repository.upset(item)
        }
    }

    fun getAllUserData() = repository.getAllUserData()

}