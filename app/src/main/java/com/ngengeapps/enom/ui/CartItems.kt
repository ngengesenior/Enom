package com.ngengeapps.enom.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngengeapps.enom.R
import com.ngengeapps.enom.data.Item
import com.ngengeapps.enom.data.sampleItems
import com.ngengeapps.enom.ui.theme.EnomTheme

@Composable
fun CartList(items:List<Item>){

    Box(modifier = Modifier.fillMaxSize()) {

        LazyColumn(modifier = Modifier.padding(horizontal = 8.dp)){
            item {
                Text(text = "My Shopping \nCart",style = MaterialTheme.typography.h4)

            }
            items(items = items){ item ->
                CartItem(item = item )
                Spacer(modifier = Modifier.height(16.dp))
            }
        } // End of Lazy Column


        Card(
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
                .padding(bottom = 4.dp)
                .align(Alignment.BottomCenter)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
            ) {
                Button(onClick = {  },elevation = elevation(
                    defaultElevation = 0.dp
                )) {
                    Text(text = "Checkout")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Total: €3,500",
                    fontWeight = FontWeight.Bold)
            }
        }

    }
    

}


@Composable
fun ItemsCart() {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                title = {
                    Text(text = "enom",modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center)
                },
                navigationIcon = {
                    Icon(painter = painterResource(R.drawable.arrow_left), contentDescription = null )
                },
                backgroundColor = MaterialTheme.colors.surface
            ,actions = {
                Icon(painter = painterResource(R.drawable.more), contentDescription = null)
                })
        }
    ) {
        CartList(items = sampleItems)

    }
}

@Preview(showBackground = true)
@Composable
fun CartListPreview(){
    EnomTheme {
        ItemsCart()
    }
}