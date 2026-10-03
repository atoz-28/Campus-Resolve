package com.campusresolve.app.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onReportIssue: () -> Unit,
    onMyReports: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top
    ) {

        // Header
        Text(
            text = "Welcome to CampusResolve",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Report and track campus concerns easily.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Report Issue Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Have a campus concern?",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Report an issue and help improve our campus."
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onReportIssue
                ) {
                    Text("Report an Issue")
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Quick Actions
        Text(
            text = "Quick Actions",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            OutlinedButton(
                onClick = onMyReports,
                modifier = Modifier.weight(1f)
            ) {
                Text("My Reports")
            }

            OutlinedButton(
                onClick = {
                    // Help functionality will be added later
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Help")
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Recent Reports
        Text(
            text = "Recent Reports",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        ReportCard(
            title = "Broken Chair",
            location = "Room 302",
            status = "Pending"
        )

        Spacer(modifier = Modifier.height(10.dp))

        ReportCard(
            title = "Aircon Problem",
            location = "Room 405",
            status = "Resolved"
        )
    }
}

@Composable
fun ReportCard(
    title: String,
    location: String,
    status: String
) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = location,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "Status: $status",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}