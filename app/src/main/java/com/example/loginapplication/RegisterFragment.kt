package com.example.loginapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.loginapplication.data.AuthenticationDatabase
import com.example.loginapplication.data.entities.TableItem
import com.example.loginapplication.repositories.AuthenticationRepo
import com.example.loginapplication.viewMode.AuthenticationViewModel
import com.example.loginapplication.viewMode.AuthenticationViewModelFactory
import kotlinx.android.synthetic.main.fragment_register.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
class RegisterFragment : Fragment() {


    lateinit var registerViewModel : AuthenticationViewModel

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
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()

        rRegisterBtn.setOnClickListener {
            addItem()
        }

        rLoginBtn.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }

    }

    private fun setupViewModel() {
        registerViewModel = ViewModelProvider(this ,
            AuthenticationViewModelFactory(AuthenticationRepo(AuthenticationDatabase(requireContext()))))
            .get(AuthenticationViewModel::class.java)

    }

    private fun addItem() {
        val name  = rUsernameTV.text.toString()
        val email = rEmailTV.text.toString()
        val password = rPasswordTV.text.toString()
        val phoneNumber = rPhNumberTV.text.toString()
        val address = rAddressTV.text.toString()

        val item =  TableItem(name , email,password , phoneNumber , address)

        registerViewModel.upset(item)

    }

}