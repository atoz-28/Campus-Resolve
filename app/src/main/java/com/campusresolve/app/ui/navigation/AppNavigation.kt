package com.campusresolve.app.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.campusresolve.app.data.auth.AuthViewModel
import com.campusresolve.app.data.model.IssueFactory
import com.campusresolve.app.data.repository.FirestoreIssueRepository
import com.campusresolve.app.data.model.IssueViewModel
import com.campusresolve.app.ui.screens.admin.AdminScreen
import com.campusresolve.app.ui.screens.auth.LoginScreen
import com.campusresolve.app.ui.screens.auth.RegisterScreen
import com.campusresolve.app.ui.screens.dashboard.DashboardScreen
import com.campusresolve.app.ui.screens.home.HomeScreen
import com.campusresolve.app.ui.screens.profile.ProfileScreen
import com.campusresolve.app.ui.screens.reports.CreateIssueScreen
import com.campusresolve.app.ui.screens.reports.ReportsScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val issueRepository = FirestoreIssueRepository()

    val issueViewModel: IssueViewModel = viewModel(
        factory = IssueFactory(issueRepository)
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBottomBar =
        currentRoute != Screen.Login.route &&
                currentRoute != Screen.Register.route

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                NavigationBar {

                    NavigationBarItem(
                        selected = currentRoute == Screen.Home.route,
                        onClick = {
                            navController.navigate(Screen.Home.route) {
                                launchSingleTop = true
                            }
                        },
                        icon = { Text("⌂") },
                        label = { Text("Home") }
                    )

                    NavigationBarItem(
                        selected = currentRoute == Screen.Dashboard.route,
                        onClick = {
                            navController.navigate(Screen.Dashboard.route) {
                                launchSingleTop = true
                            }
                        },
                        icon = { Text("▣") },
                        label = { Text("Dashboard") }
                    )

                    NavigationBarItem(
                        selected = currentRoute == Screen.Reports.route,
                        onClick = {
                            navController.navigate(Screen.Reports.route) {
                                launchSingleTop = true
                            }
                        },
                        icon = { Text("▤") },
                        label = { Text("Reports") }
                    )

                    NavigationBarItem(
                        selected = currentRoute == Screen.Profile.route,
                        onClick = {
                            navController.navigate(Screen.Profile.route) {
                                launchSingleTop = true
                            }
                        },
                        icon = { Text("●") },
                        label = { Text("Profile") }
                    )

                    NavigationBarItem(
                        selected = currentRoute == Screen.Admin.route,
                        onClick = {
                            navController.navigate(Screen.Admin.route) {
                                launchSingleTop = true
                            }
                        },
                        icon = { Text("A") },
                        label = { Text("Admin") }
                    )
                }
            }
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {

            composable(Screen.Login.route) {
                val authViewModel: AuthViewModel = viewModel()

                LoginScreen(
                    viewModel = authViewModel,
                    onLoginSuccess = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Login.route) {
                                inclusive = true
                            }
                        }
                    },
                    onRegisterClick = {
                        navController.navigate(Screen.Register.route)
                    }
                )
            }

            composable(Screen.Register.route) {
                val authViewModel: AuthViewModel = viewModel()

                RegisterScreen(
                    viewModel = authViewModel,
                    onRegisterSuccess = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Register.route) {
                                inclusive = true
                            }
                        }
                    },
                    onLoginClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable(Screen.Home.route) {
                HomeScreen(
                    viewModel = issueViewModel,
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
                ReportsScreen(viewModel = issueViewModel)
            }

            composable(Screen.CreateIssue.route) {
                CreateIssueScreen(
                    viewModel = issueViewModel,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }

            composable(Screen.Profile.route) {
                val authViewModel: AuthViewModel = viewModel()

                ProfileScreen(
                    onLogout = {
                        authViewModel.logout()

                        navController.navigate(Screen.Login.route) {
                            popUpTo(0) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                    }
                )
            }

            composable(Screen.Admin.route) {
                AdminScreen(viewModel = issueViewModel)
            }
        }
    }
}
