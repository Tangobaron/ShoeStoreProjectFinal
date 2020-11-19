@file:Suppress("KDocUnresolvedReference")

package com.raphaelbaron.shoestoreproject.shoeInventory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.raphaelbaron.shoestoreproject.R
import com.raphaelbaron.shoestoreproject.Shoe
import com.raphaelbaron.shoestoreproject.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DetailFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)

        binding.shoe = Shoe()

        binding.cancelShoeButton.setOnClickListener { shoeDetailNavigation(it) }

        binding.saveShoeButton.setOnClickListener {
            val viewModel: InventoryViewModel =
                ViewModelProvider(requireActivity()).get(InventoryViewModel::class.java)
            val shoe = binding.shoe!!

            if (shoe.label.isEmpty() || shoe.name.isEmpty() || shoe.company.isEmpty() || shoe.size.isEmpty() || shoe.description.isEmpty()) {
                Toast.makeText(activity, "Fields cannot be empty ", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.addShoesToInventory(binding.shoe!!)
                shoeDetailNavigation(it)
            }
        }
        return binding.root
    }

    private fun shoeDetailNavigation(view: View) {
        view.findNavController().navigate(DetailFragmentDirections.actionDetailToInventory())
    }
}