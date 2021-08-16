package com.ngengeapps.enom.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home"){
            HomeUI(onCartClick = {
                navController.navigate("cart")
            },onItemClick = {
                navController.navigate("detail")
            })
        }

        composable(route = "cart"){
            ItemsCart()
        }

        composable(route = "detail"){
            ItemDetailScaffold()
        }
    }


}