package com.example.loginapplication.viewMode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginapplication.repositories.AuthenticationFirebaseRepo

class AuthenticationFirebaseViewModelFactory(private var repository : AuthenticationFirebaseRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthenticationFirebaseViewModel(repository) as T

    }

}