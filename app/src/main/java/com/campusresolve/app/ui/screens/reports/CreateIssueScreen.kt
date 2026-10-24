
package com.campusresolve.app.ui.screens.reports

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.campusresolve.app.data.model.IssueViewModel

@Composable
fun CreateIssueScreen(
    viewModel: IssueViewModel,
    onBack: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var isSubmitting by remember { mutableStateOf(false) }

    val context = LocalContext.current

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

        Text("Provide the details of the campus concern.")

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Issue Title") },
            placeholder = { Text("e.g. Broken Chair") },
            singleLine = true,
            enabled = !isSubmitting
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            label = { Text("Description") },
            placeholder = { Text("Describe the problem...") },
            enabled = !isSubmitting
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Location") },
            placeholder = { Text("e.g. Room 302") },
            singleLine = true,
            enabled = !isSubmitting
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                when {
                    title.isBlank() -> {
                        Toast.makeText(
                            context,
                            "Please enter an issue title.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    description.isBlank() -> {
                        Toast.makeText(
                            context,
                            "Please enter a description.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    location.isBlank() -> {
                        Toast.makeText(
                            context,
                            "Please enter the location.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    else -> {
                        isSubmitting = true

                        viewModel.addIssue(
                            title = title.trim(),
                            description = description.trim(),
                            location = location.trim(),
                            onSuccess = {
                                isSubmitting = false

                                Toast.makeText(
                                    context,
                                    "Report submitted successfully!",
                                    Toast.LENGTH_SHORT
                                ).show()

                                onBack()
                            },
                            onFailure = { error ->
                                isSubmitting = false

                                Toast.makeText(
                                    context,
                                    "Failed to submit: ${error.message}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isSubmitting
        ) {
            if (isSubmitting) {
                CircularProgressIndicator(
                    modifier = Modifier.height(20.dp),
                    strokeWidth = 2.dp
                )
            } else {
                Text("Submit Report")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth(),
            enabled = !isSubmitting
        ) {
            Text("Cancel")
        }
    }
}
