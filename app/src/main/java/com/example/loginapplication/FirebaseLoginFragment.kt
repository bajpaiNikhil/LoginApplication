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
import com.example.loginapplication.viewMode.AuthenticationViewModelFactory
import kotlinx.android.synthetic.main.fragment_firebase_login.*

class FirebaseLoginFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_firebase_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        fireBaseRegisterBtn.setOnClickListener {
            findNavController().navigate(R.id.firebaseRegisterFragment)

        }

        firebaseLoginBtn.setOnClickListener {

            val firebaseViewModel = ViewModelProvider(this , AuthenticationFirebaseViewModelFactory(AuthenticationFirebaseRepo()))
                .get(AuthenticationFirebaseViewModel::class.java)

            var email  = firebaseLoginEmailTv.text.toString()
            var password = firebaseLoginPasswordTv.text.toString()
            firebaseViewModel.loginUserInFirebase(email , password)

            firebaseViewModel.loginUserData.observe(viewLifecycleOwner , Observer {
                Log.d("fbLoginFragment", "login Access")
            })
        }






    }
}