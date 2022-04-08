package com.stocksignalplusapp.us.ui.feature.signin.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.stocksignalplusapp.us.R

class SignInFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val goToSignUp: TextView = view.findViewById(R.id.goto_signup)
        goToSignUp.setOnClickListener {
            findNavController().navigate(
                SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        }

        val backToSignUp: ImageView = view.findViewById(R.id.back_to_signup)
        backToSignUp.setOnClickListener {
            findNavController().navigate(
                SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }
}