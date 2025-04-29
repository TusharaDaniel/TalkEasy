package com.klu.talkeasy

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationGraph(
    navController: NavHostController,
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    paddingValues: PaddingValues // Accept paddingValues as a parameter
) {
    NavHost(navController = navController, startDestination = "homeScreen") {
        composable("homeScreen") { HomeScreen(navController, paddingValues) }
        composable("lessonScreen") { LessonScreen(navController, paddingValues) }
        composable("profileScreen") { ProfileScreen(navController, paddingValues) }
        composable("streak_screen") {
            StreakScreen(navController = navController)
        }
        composable("quizScreen") {
            QuizScreen(navController = navController)
        }

    }
}
