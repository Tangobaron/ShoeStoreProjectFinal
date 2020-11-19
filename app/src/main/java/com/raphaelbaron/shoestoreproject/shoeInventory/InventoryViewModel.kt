package com.raphaelbaron.shoestoreproject.shoeInventory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raphaelbaron.shoestoreproject.Shoe

class InventoryViewModel : ViewModel() {

    val shoeListMLD = MutableLiveData<List<Shoe>>()
    private val shoeInventory = ArrayList<Shoe>()

    fun addShoesToInventory(shoe: Shoe) {
        shoeInventory.add(shoe)
        shoeListMLD.value = shoeInventory
    }

}