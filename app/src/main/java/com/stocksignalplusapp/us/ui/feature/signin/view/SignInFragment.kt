package com.stocksignalplusapp.us.ui.feature.signin.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentSignInBinding

class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    private val binding by viewBinding(FragmentSignInBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentSigninBackBtn.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.gotoSignup.setOnClickListener {
            findNavController()
                .navigate(SignInFragmentDirections.actionSignInFragmentToSignUpFragment())
        }
    }
}