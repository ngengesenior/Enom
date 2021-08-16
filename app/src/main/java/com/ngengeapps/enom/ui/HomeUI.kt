package com.ngengeapps.enom.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ngengeapps.enom.R
import com.ngengeapps.enom.ui.theme.EnomTheme
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.style.TextAlign
import com.ngengeapps.enom.data.sampleItems2
import com.ngengeapps.enom.data.titles

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun HomeUI(onCartClick:()->Unit,onItemClick:()->Unit){

    var selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Scaffold(topBar = {
        TopAppBar(
            elevation = 0.dp,
            title = {
                Text(text = "enom",modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center)
            },
            navigationIcon = {
                Icon(Icons.Default.Menu, contentDescription = null )
            },
            backgroundColor = MaterialTheme.colors.surface
            ,actions = {
                BadgeBox(modifier = Modifier.clickable {onCartClick()},
                    badgeContent = {
                        Text(text = "3",modifier = Modifier.padding(end = 2.dp))
                    }
                ){
                    Icon(painter = painterResource(R.drawable.shopping_cart),
                        contentDescription = null)
                }

            })
    }) {
        Column(modifier = Modifier.padding(horizontal = 6.dp)) {
            Text(text = "Build Your\nSmall Office.",
                style = MaterialTheme.typography.h5)
            Image(painter = painterResource(R.drawable.chair_4),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop)
            TabRow(selectedTabIndex = selectedIndex ,
                backgroundColor = MaterialTheme.colors.surface) {
                titles.forEachIndexed{ index,title ->
                    Tab(selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        text = { Text(text = title)})

                }
            }

            // Grid of items
            LazyVerticalGrid(cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp)) {

                items(items = sampleItems2){ item ->
                    Image(painter = painterResource(item.image),
                        contentDescription = null,
                        modifier = Modifier.clickable { onItemClick() }, )
                    Spacer(modifier = Modifier.height(6.dp))
                }

            }
        }
    }

}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview(showSystemUi = true,showBackground = true)
@Composable
fun HomePreview(){
    EnomTheme {
        HomeUI(onItemClick= {},onCartClick = {})
    }
}