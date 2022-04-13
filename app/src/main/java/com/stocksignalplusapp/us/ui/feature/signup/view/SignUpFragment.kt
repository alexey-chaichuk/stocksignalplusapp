package com.stocksignalplusapp.us.ui.feature.signup.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.stocksignalplusapp.us.R
import com.stocksignalplusapp.us.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {
    private val binding by viewBinding(FragmentSignUpBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fragmentSignupBackBtn.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.gotoSignin.setOnClickListener {
            findNavController()
                .navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
        }
    }
}