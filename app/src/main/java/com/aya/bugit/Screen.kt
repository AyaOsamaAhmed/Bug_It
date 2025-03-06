package com.aya.bugitshared

sealed class Screen (val route : String){
    object SubmitBugScreen : Screen("submit_bug_screen")
    object BugListScreen : Screen("bug_list_screen")

}