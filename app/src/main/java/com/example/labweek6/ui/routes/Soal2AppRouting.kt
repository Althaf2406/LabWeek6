package com.example.labweek6.ui.routes

import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.size.Scale
import com.example.labweek6.ui.model.listAktivitas
import com.example.labweek6.ui.viewmodel.Soal2ViewModel
import com.example.labweek6.ui.model.listTeman
import com.example.labweek6.ui.view.Soal2
import com.example.labweek6.ui.view.Soal2Exercise
import com.example.labweek6.ui.view.Soal2Friend

enum class Soal2AppView(val title: String, val icon: ImageVector? = null) {
    Soal2("Soal2", Icons.Default.AccountCircle),
    Soal2Friend("Soal2FriendView", Icons.Default.Groups),
    Soal2Exercise("Soal2ExerciseView", Icons.Default.LocalFireDepartment)

}

data class BottomNavItem(val view: Soal2AppView, val label:String)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(
    currentView: Soal2AppView?,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(currentView?.title ?: "") },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }

    )
}

@Composable
fun MyBottoNavigationBar(
    navController: NavHostController,
    currentDestination: NavDestination?,
    items: List<BottomNavItem>
){
    if(items.any{it.view.name == currentDestination?.route}){
        NavigationBar{
            items.forEach{ item ->
                NavigationBarItem(
                    icon = { Icon(item.view.icon!!, contentDescription = item.label) },
                    label = { Text(item.label) },
                    selected = currentDestination?.hierarchy?.any { it.route == item.view.name } == true,
                    onClick = { navController.navigate(item.view.name) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                        }
                    }
                )
            }
        }
    }
}
@Composable
fun Soal2AppRouting(){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = currentDestination?.route
    val currentView = Soal2AppView.entries.find { it.name == currentRoute  }

    val bottomNavItems = listOf(
        BottomNavItem(Soal2AppView.Soal2, "Soal2"),
        BottomNavItem(Soal2AppView.Soal2Friend, "Soal2FriendView"),
        BottomNavItem(Soal2AppView.Soal2Exercise, "Soal2ExerciseView")
    )

    Scaffold (
        topBar = {
            MyTopAppBar(
                currentView = currentView,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }
            )
        },

        bottomBar = {
            MyBottoNavigationBar(
                navController = navController,
                currentDestination = currentDestination,
                items = bottomNavItems
            )
        }
    ){
        innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Soal2AppView.Soal2.name

        ){
            composable(route = Soal2AppView.Soal2.name){
                Soal2(navController = rememberNavController())
            }
            composable(route = Soal2AppView.Soal2Friend.name){
                Soal2Friend()
            }
            composable(route = Soal2AppView.Soal2Exercise.name){
                Soal2Exercise()
            }
        }

    }

}
