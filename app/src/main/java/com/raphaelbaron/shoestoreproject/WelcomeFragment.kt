package com.raphaelbaron.shoestoreproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.raphaelbaron.shoestoreproject.databinding.WelcomeFragmentBinding

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: WelcomeFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.welcome_fragment, container, false)

        binding.continueToInstructionsButton.setOnClickListener { findNavController().navigate(WelcomeFragmentDirections.actionWelcomeToInstructions()) }

        return binding.root
    }
}