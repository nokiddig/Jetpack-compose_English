@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.english_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.english_app.domain.constain.RouteConst
import com.example.english_app.ui.theme.English_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            English_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController,  startDestination = RouteConst.HOME){
        composable(RouteConst.HOME){ Greeting(navController = navController)}
        composable(RouteConst.HOME){ Greeting(navController = navController)}
        composable(RouteConst.HOME){ Greeting(navController = navController)}
        composable(RouteConst.HOME){ Greeting(navController = navController)}
    }
    Greeting(navController)
}


data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

@Composable
fun Greeting(navController: NavController) {
    val  items = listOf(
        BottomNavItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        BottomNavItem(
            title = "Send messages",
            selectedIcon = Icons.Filled.Share,
            unSelectedIcon = Icons.Outlined.Share,
            hasNews = false
        )
    )
    var selectedIndex by rememberSaveable {
        mutableStateOf(0)
    }
    Scaffold (modifier = Modifier.padding(5.dp),
        topBar = {
            TopAppBar(title = { Text(text = "Home")},
            navigationIcon = {

                BackButton{
                    navController.popBackStack()
                }
            })
        },
        content = {
            Text(text = "dm", modifier = Modifier.padding(it))
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedIndex,
                        onClick = {
                            selectedIndex = index
                            navController.navigate(item.title)
                        },
                        icon = {
                            BadgedBox(badge = {

                            }) {
                                Icon(imageVector = if (index == selectedIndex) item.selectedIcon
                                    else item.unSelectedIcon,
                                    contentDescription = item.title)
                            }
                        },
                        label = {Text(text = item.title)})
                }
            }
        }
    )
}
@Composable
fun BackButton(onclick: () -> Unit) {
    IconButton(onClick = onclick) {
        Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
    }
}