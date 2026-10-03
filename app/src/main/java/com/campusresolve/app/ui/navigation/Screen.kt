package com.campusresolve.app.ui.navigation

sealed class Screen(val route: String) {

    data object Login : Screen("login")
    data object Register : Screen("register")
    data object Home : Screen("home")
    data object Dashboard : Screen("dashboard")
    data object Reports : Screen("reports")
    data object CreateIssue : Screen("create_issue")
    data object Profile : Screen("profile")
    data object Admin : Screen("admin")
}