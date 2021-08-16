package com.ngengeapps.enom.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ngengeapps.enom.R
import com.ngengeapps.enom.data.Item
import com.ngengeapps.enom.data.description
import com.ngengeapps.enom.data.sampleItems
import com.ngengeapps.enom.ui.theme.EnomTheme
import kotlin.random.Random


@Composable
fun ItemDetailUI(item: Item) {

    Column {
        Image(
            painter = painterResource(item.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = item.name, style = MaterialTheme.typography.h4)
            Text(text = "€${item.pricePerUnit}", style = MaterialTheme.typography.h4)

        }

        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Description", color = MaterialTheme.colors.primary)
            Text(text = "Specification")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = description, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(8.dp))
        Divider()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 4.dp)
            ) {
                Text(text = item.contents)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(R.drawable.arrow_down),
                    contentDescription = null
                )
            }
        } // End of card

        Button(
            onClick = { }, modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(text = "Add To Cart")
        }


    }
}

@Composable
fun ItemDetailScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = stringResource(R.string.app_name),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 10.dp),
                textAlign = TextAlign.Center
            ) },navigationIcon = {
                Icon(painter = painterResource(R.drawable.arrow_left),
                    contentDescription = null )
            },actions = {
                Icon(painter = painterResource(R.drawable.more),
                    contentDescription = null )
            })
        }
    ) {
        ItemDetailUI(item = sampleItems[Random.nextInt(0, sampleItems.size-1)])

    }
}

@Preview(showBackground = true)
@Composable
fun ItemDetailPreview() {
    EnomTheme {
        ItemDetailScaffold()

    }
}

