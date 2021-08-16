package com.ngengeapps.enom.data

import androidx.annotation.DrawableRes
import com.ngengeapps.enom.R

data class Item(
    val name:String,
    val pricePerUnit:Long,
    @DrawableRes val image:Int,
    val contents:String
)

val sampleItems = listOf(
    Item(
        name = "Tirta",
        pricePerUnit = 1000,
        image = R.drawable.chair_1,
        contents = "Aluminium,Mapple"
    ),
    Item(
        name = "Verkudara",
        pricePerUnit = 1200,
        image = R.drawable.chair_2,
        contents = "ABS,Mapple"
    ),
    Item(
        name = "Surya",
        pricePerUnit = 1400,
        image = R.drawable.chair_3,
        contents = "Jati,Mapple"
    ),
    Item(
        name = "Berish",
        pricePerUnit = 1500,
        image = R.drawable.chair_4,
        contents = "Aluminium,Mapple"
    ),
    Item(
        name = "Aristish",
        pricePerUnit = 1500,
        image = R.drawable.chair_5,
        contents = "Aluminium,Mapple"
    )
)

val sampleItems2 = sampleItems + sampleItems

val description = "The dynamic desk nis suitable for the home" +
        "and office.The two spacious drawers hide candies and workbooks" +
        "equally well.Made of birch mapple, also oak veneered, oil-maxed.Drawers Koskisen CPL on " +
        "plywood.Soft close drawer rails.Collection MAN was nominated for Estonian design award Bruno 2016."

val titles = listOf("All","Chair","Lamp","Storage")