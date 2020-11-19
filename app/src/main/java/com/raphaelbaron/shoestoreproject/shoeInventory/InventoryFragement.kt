package com.raphaelbaron.shoestoreproject.shoeInventory

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.raphaelbaron.shoestoreproject.R
import com.raphaelbaron.shoestoreproject.Shoe
import com.raphaelbaron.shoestoreproject.databinding.InventoryFragmentBinding

class InventoryFragement : Fragment() {

    private lateinit var viewModel: InventoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding: InventoryFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.inventory_fragment, container, false)

        binding.toShoeDetailFAB.setOnClickListener {
            findNavController().navigate(
                InventoryFragementDirections.actionInventoryToDetail()
            )
        }
        viewModel = ViewModelProvider(requireActivity()).get(InventoryViewModel::class.java)

        viewModel.shoeListMLD.observe(viewLifecycleOwner, {
            it.forEach { shoe: Shoe ->
                addShoeDetailToInventory(binding.root, shoe)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }


//Used https://github.com/ShubhamSrivastava93/ShoeStore.git version for the following part since I misunderstood the application of DataBinding from an EditText
    private fun addShoeDetailToInventory(inventoryList: View, shoe: Shoe) {
        val shoeListItem =
            LayoutInflater.from(context).inflate(R.layout.shoe_list_item, null, false)

        val shoeLabelInflated: TextView =
            shoeListItem.findViewById(R.id.shoeDetailsLabel) as TextView
        val shoeNameInflated: TextView = shoeListItem.findViewById(R.id.shoeDetailsName) as TextView
        val shoeCompanyInflated: TextView =
            shoeListItem.findViewById(R.id.shoeDetailsCompany) as TextView
        val shoeSizeInflated: TextView = shoeListItem.findViewById(R.id.shoeDetailsSize) as TextView
        val shoeDescriptionInflated: TextView =
            shoeListItem.findViewById(R.id.shoeDetailsDescription) as TextView

        shoeLabelInflated.text = getString(R.string.label_format, shoe.label)
        shoeNameInflated.text = getString(R.string.name_format, shoe.name)
        shoeCompanyInflated.text = getString(R.string.company_format, shoe.company)
        shoeSizeInflated.text = getString(R.string.size_format, shoe.size)
        shoeDescriptionInflated.text = getString(R.string.description_format, shoe.description)

        val linearLayout = inventoryList.findViewById(R.id.inventoryLinearLayout) as LinearLayout
        linearLayout.addView(shoeListItem)
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