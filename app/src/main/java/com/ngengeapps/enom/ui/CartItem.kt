package com.ngengeapps.enom.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.ngengeapps.enom.data.Item
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngengeapps.enom.data.sampleItems
import com.ngengeapps.enom.ui.theme.EnomTheme

@Composable
fun CartItem(item: Item){
    var  numItems by remember {
        mutableStateOf(1)
    }

    Card(elevation = 0.dp) {
        Row() {
            Image(painter = painterResource(item.image) , contentDescription = "Image of ${item.name}",
                contentScale = ContentScale.Crop,modifier = Modifier.size(120.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Column(verticalArrangement = Arrangement.Center,modifier = Modifier.height(120.dp)) {
                Text(text = item.name,style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.contents,style = MaterialTheme.typography.caption)
                Spacer(modifier = Modifier.height(4.dp))
                Divider()
                Spacer(modifier = Modifier.height(4.dp))
                Row() {
                    Text(text = "-")
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = numItems.toString())
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "+")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "€${item.pricePerUnit}",fontWeight = FontWeight.Bold)
                }
            }
        }
    }

}

@Preview(device = Devices.PIXEL_4,showBackground = true)
@Composable
fun CartItemPreview() {
    EnomTheme() {
        CartItem(item = sampleItems[0])
    }
}