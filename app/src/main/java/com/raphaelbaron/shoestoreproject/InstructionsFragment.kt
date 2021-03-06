package com.raphaelbaron.shoestoreproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.raphaelbaron.shoestoreproject.databinding.InstructionsFragmentBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InstructionsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.instructions_fragment, container, false)

        binding.continueToInventoryButton.setOnClickListener {
            findNavController().navigate(
                InstructionsFragmentDirections.actionInstructionsToInventory()
            )
        }

        return binding.root
    }
}