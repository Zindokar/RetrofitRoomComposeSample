package iesharia.retrofit2example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import iesharia.retrofit2example.data.ProductViewModel
import iesharia.retrofit2example.ui.theme.RetroFit2ExampleTheme

enum class ScreenList() {
    ProductList,
    FavoriteList
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetroFit2ExampleTheme(dynamicColor = false) {
                val navController: NavHostController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomAppBar(
                            actions = {
                                BottomBarItems(navController)
                            }
                        )
                    }
                ) { innerPadding ->
                    val productViewModel: ProductViewModel = viewModel()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenList.ProductList.name,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        composable(route = ScreenList.ProductList.name) {
                            ProductListScreen(productViewModel)
                        }
                        composable(route = ScreenList.FavoriteList.name) {
                            FavoriteListScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomBarItems(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = { navController.navigate(ScreenList.ProductList.name) },
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Filled.Home, contentDescription = "Lista Productos"
            )
        }
        IconButton(
            modifier = Modifier.padding(start = 30.dp),
            onClick = { navController.navigate(ScreenList.FavoriteList.name) },
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Filled.Favorite, contentDescription = "Favoritos Productos"
            )
        }
    }
}