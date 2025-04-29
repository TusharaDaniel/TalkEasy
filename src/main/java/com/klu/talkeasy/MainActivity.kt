package com.klu.talkeasy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            var selectedTab by remember { mutableStateOf(0) }

            // The Scaffold will now be at a higher level, ensuring the bottom nav is present across all screens
            Scaffold(
                topBar = { TopAppBar(title = { Text("TalkEasy") }) },
                bottomBar = {
                    // Bottom navigation bar stays here, it will be available on every screen
                    NavigationBar {
                        NavigationBarItem(
                            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                            label = { Text("Home") },
                            selected = selectedTab == 0,
                            onClick = {
                                selectedTab = 0
                                navController.navigate("homeScreen") {
                                    // This ensures navigating to HomeScreen removes previous stack screens
                                    launchSingleTop = true
                                    popUpTo("homeScreen") { inclusive = true }
                                }
                            }
                        )
                        NavigationBarItem(
                            icon = { Icon(Icons.Filled.Menu, contentDescription = "Lessons") },
                            label = { Text("Lessons") },
                            selected = selectedTab == 1,
                            onClick = {
                                selectedTab = 1
                                navController.navigate("lessonScreen") {
                                    launchSingleTop = true
                                    popUpTo("lessonScreen") { inclusive = true }
                                }
                            }
                        )
                        NavigationBarItem(
                            icon = { Icon(Icons.Filled.Person, contentDescription = "Profile") },
                            label = { Text("Profile") },
                            selected = selectedTab == 2,
                            onClick = {
                                selectedTab = 2
                                navController.navigate("profileScreen") {
                                    launchSingleTop = true
                                    popUpTo("profileScreen") { inclusive = true }
                                }
                            }
                        )
                    }
                }
            ) { paddingValues ->
                // Pass the paddingValues to NavigationGraph
                NavigationGraph(navController, selectedTab, { newTab -> selectedTab = newTab }, paddingValues)
            }
        }
    }
}
