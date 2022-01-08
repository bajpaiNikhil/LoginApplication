package com.example.loginapplication.repositories


import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class AuthenticationFirebaseRepo() {
    private lateinit var auth : FirebaseAuth

    var firebaseUserWeHave : MutableLiveData<FirebaseUser> = MutableLiveData()
    var firebaseLoginUserWeHave : MutableLiveData<FirebaseUser> = MutableLiveData()

    fun registerUser(email:String ,password:String){
        auth = FirebaseAuth.getInstance()
        auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener{
            if(it.isSuccessful){
                firebaseUserWeHave.value = auth.currentUser
                Log.d("FbRepo" , "this is from here22 ${it.result} , ${firebaseUserWeHave}")
            }else{
                Log.d("FbRepo" , "this is from here ${it.result} , ${firebaseUserWeHave}")
            }
        }
    }

    fun loginUser(email: String , password: String){
        auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email , password).addOnCompleteListener {
            if (it.isSuccessful){
                firebaseLoginUserWeHave.value = auth.currentUser
                Log.d("FbRepo" , "this is from here33 ${it.result} , ${firebaseLoginUserWeHave}")
            }else{
                Log.d("FbRepo" , "this is from here11 ${it.result} , ${firebaseLoginUserWeHave}")
            }
        }
    }
}