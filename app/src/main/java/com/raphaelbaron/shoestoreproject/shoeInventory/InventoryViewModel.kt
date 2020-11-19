package com.raphaelbaron.shoestoreproject.shoeInventory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raphaelbaron.shoestoreproject.Shoe

class InventoryViewModel : ViewModel() {

    private val shoeListMLD = MutableLiveData<MutableList<Shoe>>()
    private val shoeInventory = ArrayList<Shoe>()
    val shoes: LiveData<MutableList<Shoe>> get() = shoeListMLD

    init {
        shoeListMLD.value = ArrayList()
    }

    fun addShoesToInventory(shoe: Shoe) {
        shoeInventory.add(shoe)
        shoeListMLD.value = shoeInventory
    }
}