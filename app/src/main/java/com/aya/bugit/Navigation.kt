package com.aya.bugitshared

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.aya.domain.model.BugItem

@Composable
fun  Navigation () {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.BugListScreen.route) {
        composable(route = Screen.BugListScreen.route) {
            BugListScreen(navController = navController)
        }
        composable(route = Screen.SubmitBugScreen.route) {
            BugSubmissionScreen(navController = navController)
        }
    }

}



@Composable
fun BugListScreen(navController: NavController) {
    val bugReports = listOf(
             BugItem("1", "App crashes on login", "https://drive.google.com/uc?export=view&id=16qmnCgciNyCXhkrR6yF22T3V5E1H9z2c", "26-09-23"),
            BugItem("2", "Submit button not working", "https://drive.google.com/uc?export=view&id=16qmnCgciNyCXhkrR6yF22T3V5E1H9z2c", "26-09-23"),
            BugItem("3", "Text overlapping in dark mode", "https://drive.google.com/uc?export=view&id=16qmnCgciNyCXhkrR6yF22T3V5E1H9z2c", "26-09-23")
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.SubmitBugScreen .route) } ,
                containerColor = Color.Green // Change FAB color to Green
            ) {
                Text("+") // You can replace this with an icon
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            items(bugReports) { bug ->
                BugItem(bug)
            }
        }

    }
}

@Composable
fun BugItem(bug : BugItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = bug.imageUrl,
                contentDescription = "Bug Screenshot",
                modifier = Modifier.size(50.dp),
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = bug.description)
        }
    }
}

@Composable
fun BugSubmissionScreen(navController: NavController) {
    var bugDescription by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val pickImageLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        imageUri = uri
    }

    Column(modifier = Modifier.fillMaxSize().padding(top = 50.dp , start = 20.dp , end = 20.dp  )) {
        Text(text = "Submit Bug", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Button(
            modifier = Modifier.padding(start = 16.dp , top = 120.dp).fillMaxWidth(),
            onClick = { pickImageLauncher.launch("image/*")  }) {
            Text("Attach Screenshot")
        }


        imageUri?.let { uri ->
            AsyncImage(
                model = uri,
                contentDescription = "Bug Screenshot",
                modifier = Modifier.size(200.dp),
            )
        }

        TextField(
            modifier = Modifier.padding(start = 16.dp , top = 20.dp).fillMaxWidth().height(150.dp),
            value = bugDescription, onValueChange = { bugDescription = it },
            maxLines = 5,
            label = { Text("Bug Description") })

        Row(modifier = Modifier.fillMaxSize().padding(top = 50.dp , start = 20.dp , end = 20.dp  )) {

            Button(
                modifier = Modifier.padding(start = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray),
                onClick = { navController.popBackStack() }) {
                Text("Go Back")
            }


            Button(
                modifier = Modifier.padding(start = 26.dp).width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green),
                onClick = { /* Save Bug Report */ }) {
                Text("Submit Bug")
            }

        }

    }
}
