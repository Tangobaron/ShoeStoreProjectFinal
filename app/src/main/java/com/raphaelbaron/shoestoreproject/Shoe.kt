package com.raphaelbaron.shoestoreproject

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Shoe(
    var label: String = "",
    var name: String = "",
    var company: String = "",
    var size: String = "",
    var description: String = ""
) : Parcelable