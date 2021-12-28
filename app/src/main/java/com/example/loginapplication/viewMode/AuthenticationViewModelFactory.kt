package com.example.loginapplication.viewMode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginapplication.repositories.AuthenticationRepo

class AuthenticationViewModelFactory( private val repository : AuthenticationRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthenticationViewModel(repository) as T
    }
}