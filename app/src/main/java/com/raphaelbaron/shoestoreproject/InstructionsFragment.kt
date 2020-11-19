package com.raphaelbaron.shoestoreproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.raphaelbaron.shoestoreproject.databinding.InstructionsFragmentBinding

/**
 * A simple [Fragment] subclass.
 * Use the [InstructionsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: InstructionsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.instructions_fragment, container, false)

        binding.continueToInventoryButton.setOnClickListener {
            findNavController().navigate(
                InstructionsFragmentDirections.actionInstructionsFToInventoryF()
            )
        }

        return binding.root
    }
}