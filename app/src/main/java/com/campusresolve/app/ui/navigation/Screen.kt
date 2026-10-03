package com.campusresolve.app.ui.navigation

sealed class Screen(val route: String) {

    data object Home : Screen("home")
    data object Dashboard : Screen("dashboard")
    data object Reports : Screen("reports")
    data object CreateIssue : Screen("create_issue")
    data object Profile : Screen("profile")
}