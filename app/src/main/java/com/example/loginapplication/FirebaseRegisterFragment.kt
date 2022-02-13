package com.example.loginapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.loginapplication.repositories.AuthenticationFirebaseRepo
import com.example.loginapplication.viewMode.AuthenticationFirebaseViewModel
import com.example.loginapplication.viewMode.AuthenticationFirebaseViewModelFactory
import kotlinx.android.synthetic.main.fragment_firebase_register.*


class FirebaseRegisterFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_firebase_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseRegisterLoginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firebaseRegisterFragment_to_firebaseLoginFragment)
        }

        firebaseRRegisterBtn.setOnClickListener {
            val firebaseViewModel = ViewModelProvider(this , AuthenticationFirebaseViewModelFactory(
                AuthenticationFirebaseRepo()))
                .get(AuthenticationFirebaseViewModel::class.java)

            val email = firebaseRegisterEmailTv.text.toString()
            val password = firebaseRegisterPasswordTv.text.toString()
            firebaseViewModel.registerUserInFirebase(email , password)
            firebaseViewModel.userData.observe(viewLifecycleOwner  , Observer {
                Log.d("fbRegisterFragment" ,it.toString() )
            })
        }
    }
}