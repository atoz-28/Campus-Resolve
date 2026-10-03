package com.campusresolve.app.ui.screens.reports

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Report(
    val title: String,
    val location: String,
    val category: String,
    val status: String
)

@Composable
fun ReportsScreen() {

    val reports = listOf(
        Report(
            title = "Broken Chair",
            location = "Room 302",
            category = "Maintenance",
            status = "Pending"
        ),
        Report(
            title = "Aircon Problem",
            location = "Room 405",
            category = "Maintenance",
            status = "In Progress"
        ),
        Report(
            title = "Dirty Restroom",
            location = "Building A",
            category = "Cleanliness",
            status = "Resolved"
        ),
        Report(
            title = "Broken Light",
            location = "Room 201",
            category = "Maintenance",
            status = "Pending"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Reports",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "View and track submitted campus concerns.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(reports) { report ->
                ReportItem(report)
            }
        }
    }
}

@Composable
fun ReportItem(report: Report) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = report.title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = report.location,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Category: ${report.category}",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = "Status: ${report.status}",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}