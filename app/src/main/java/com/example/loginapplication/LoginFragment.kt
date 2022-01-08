package com.example.loginapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.loginapplication.data.AuthenticationDatabase
import com.example.loginapplication.repositories.AuthenticationRepo
import com.example.loginapplication.viewMode.AuthenticationViewModel
import com.example.loginapplication.viewMode.AuthenticationViewModelFactory
import kotlinx.android.synthetic.main.fragment_login.*



class LoginFragment : Fragment() {


    private lateinit var loginViewModel : AuthenticationViewModel


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
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewModel()

        registerBtn.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        loginBtn.setOnClickListener {
            checkEnteredData()
        }

    }

    private fun checkEnteredData() {
        loginViewModel.getAllUserData().observe(viewLifecycleOwner , Observer {
            for( i in it.indices){
                Log.d("LoginFragment" , it[i].toString())
                val enteredPassword = lPasswordTV.text.toString()
                val enteredEmail = lEmailTV.text.toString()

                if(enteredPassword == it[i].password || enteredEmail == it[i].email){
                    Log.d("LoginFragment" , "${it[i].password}   ${it[i].email}")
                    Toast.makeText(context  , "Access granted" ,Toast.LENGTH_LONG).show()

                    findNavController().navigate(R.id.firebaseLoginFragment)

                }else{
                    Log.d("LoginFragment" , " hehe ${it[i].password}   ${it[i].email}"  )
                    Toast.makeText(context , "incorrect password" , Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setUpViewModel() {

        loginViewModel = ViewModelProvider(this , AuthenticationViewModelFactory(
            AuthenticationRepo(AuthenticationDatabase(requireContext()))
        ))[AuthenticationViewModel::class.java]
    }
}