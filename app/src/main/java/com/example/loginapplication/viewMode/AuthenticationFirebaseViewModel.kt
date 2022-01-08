package com.example.loginapplication.viewMode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginapplication.repositories.AuthenticationFirebaseRepo
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class AuthenticationFirebaseViewModel(private  var repository : AuthenticationFirebaseRepo) : ViewModel() {

    var  userData : MutableLiveData<FirebaseUser>  = MutableLiveData()
    var loginUserData  : MutableLiveData<FirebaseUser>  = MutableLiveData()


    fun registerUserInFirebase(email:String , password:String){
        viewModelScope.launch {
            repository.registerUser(email , password)
           userData =  repository.firebaseUserWeHave
        }
    }
    fun loginUserInFirebase(email:String , password : String){
        viewModelScope.launch {
            repository.loginUser(email , password )
            loginUserData = repository.firebaseLoginUserWeHave
        }
    }

}