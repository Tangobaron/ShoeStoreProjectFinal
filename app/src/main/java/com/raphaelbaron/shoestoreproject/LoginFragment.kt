package com.raphaelbaron.shoestoreproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.raphaelbaron.shoestoreproject.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: LoginFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        binding.loginButton.setOnClickListener { welcomeNavigation(it) }
        binding.signUpTextview.setOnClickListener { welcomeNavigation(it) }

        return binding.root
    }

    private fun welcomeNavigation(view: View) {
        view.findNavController().navigate(LoginFragmentDirections.actionLoginToWelcome())
    }
}