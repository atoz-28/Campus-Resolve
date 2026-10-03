package com.campusresolve.app.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.campusresolve.app.ui.screens.dashboard.DashboardScreen
import com.campusresolve.app.ui.screens.home.HomeScreen
import com.campusresolve.app.ui.screens.profile.ProfileScreen
import com.campusresolve.app.ui.screens.reports.CreateIssueScreen
import com.campusresolve.app.ui.screens.reports.ReportsScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar {

                // HOME
                NavigationBarItem(
                    selected = currentRoute == Screen.Home.route,
                    onClick = {
                        navController.navigate(Screen.Home.route)
                    },
                    icon = {
                        Text("⌂")
                    },
                    label = {
                        Text("Home")
                    }
                )

                // DASHBOARD
                NavigationBarItem(
                    selected = currentRoute == Screen.Dashboard.route,
                    onClick = {
                        navController.navigate(Screen.Dashboard.route)
                    },
                    icon = {
                        Text("▣")
                    },
                    label = {
                        Text("Dashboard")
                    }
                )

                // REPORTS
                NavigationBarItem(
                    selected = currentRoute == Screen.Reports.route,
                    onClick = {
                        navController.navigate(Screen.Reports.route)
                    },
                    icon = {
                        Text("▤")
                    },
                    label = {
                        Text("Reports")
                    }
                )

                // PROFILE
                NavigationBarItem(
                    selected = currentRoute == Screen.Profile.route,
                    onClick = {
                        navController.navigate(Screen.Profile.route)
                    },
                    icon = {
                        Text("●")
                    },
                    label = {
                        Text("Profile")
                    }
                )
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {


            composable(Screen.Home.route) {
                HomeScreen(
                    onReportIssue = {
                        navController.navigate(Screen.CreateIssue.route)
                    },
                    onMyReports = {
                        navController.navigate(Screen.Reports.route)
                    }
                )
            }


            composable(Screen.Dashboard.route) {
                DashboardScreen()
            }


            composable(Screen.Reports.route) {
                ReportsScreen()
            }


            composable(Screen.CreateIssue.route) {
                CreateIssueScreen(
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }


            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
    }
}