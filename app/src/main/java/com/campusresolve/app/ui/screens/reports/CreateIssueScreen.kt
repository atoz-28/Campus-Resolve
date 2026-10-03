package com.campusresolve.app.ui.screens.reports

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CreateIssueScreen(
    onBack: () -> Unit
) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    var location by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Report an Issue",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Provide the details of the campus concern."
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = title,
            onValueChange = {
                title = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Issue Title")
            },
            placeholder = {
                Text("e.g. Broken Chair")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = description,
            onValueChange = {
                description = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            label = {
                Text("Description")
            },
            placeholder = {
                Text("Describe the problem...")
            }
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = location,
            onValueChange = {
                location = it
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text("Location")
            },
            placeholder = {
                Text("e.g. Room 302")
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                // kulang pako dito ng save issue
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit Report")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cancel")
        }
    }
}