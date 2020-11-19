package com.raphaelbaron.shoestoreproject.shoeInventory

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.raphaelbaron.shoestoreproject.R
import com.raphaelbaron.shoestoreproject.databinding.InventoryFragmentBinding
import com.raphaelbaron.shoestoreproject.databinding.ShoeListItemBinding

class InventoryFragment : Fragment() {

    private lateinit var viewModel: InventoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding: InventoryFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.inventory_fragment, container, false)

        binding.lifecycleOwner = this

        binding.toShoeDetailFAB.setOnClickListener {
            findNavController().navigate(
                InventoryFragmentDirections.actionInventoryToDetail()
            )
        }
        viewModel = ViewModelProvider(requireActivity()).get(InventoryViewModel::class.java)

        viewModel.shoes.observe(viewLifecycleOwner, { shoes ->
            binding.inventoryLinearLayout.removeAllViews()
            shoes.forEach { shoe ->
                val shoeItemBinding: ShoeListItemBinding =
                    DataBindingUtil.inflate(inflater, R.layout.shoe_list_item, container, false)
                shoeItemBinding.shoeDetailsLabel.text = shoe.label
                shoeItemBinding.shoeDetailsName.text = shoe.name
                shoeItemBinding.shoeDetailsCompany.text = shoe.company
                shoeItemBinding.shoeDetailsSize.text = shoe.size
                shoeItemBinding.shoeDetailsDescription.text = shoe.description
                shoeItemBinding.executePendingBindings()
                binding.inventoryLinearLayout.addView(shoeItemBinding.root)
            }
        })
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController())
                || super.onOptionsItemSelected(item)
    }
}