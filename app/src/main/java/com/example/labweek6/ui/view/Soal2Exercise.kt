package com.example.labweek6.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labweek6.ui.model.Activity
import com.example.labweek6.ui.viewmodel.Soal2ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Soal2Exercise(s2VM: Soal2ViewModel = viewModel()) {
    var showForm by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        if (showForm) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                AddWorkoutForm(
                    onSave = {
                        s2VM.addActivity(it)
                        showForm = false
                    },
                    onCancel = { showForm = false }
                )
            }
        } else {

            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Workouts", style = MaterialTheme.typography.titleLarge)

                Spacer(Modifier.height(12.dp))

                if (s2VM.aCTVPublic.isEmpty()) {
                    Text("No Workouts Found", color = Color.Gray)
                } else {
                    s2VM.aCTVPublic.forEach { aKT ->
                        ExerciseCard(
                            aKT = aKT,
                            modifier = Modifier,
                            onToggleClick = { s2VM.removeActivity(it) }
                        )
                    }
                }
            }

            FloatingActionButton(
                onClick = { showForm = true },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Workout")
            }
        }
    }
}
@Composable
fun AddWorkoutForm(
    onSave: (Activity) -> Unit,
    onCancel: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var type by remember { mutableStateOf("") }
    var calories by remember { mutableStateOf("") }
    var selectedIcon by remember { mutableStateOf(Icons.Default.FitnessCenter) } // default icon

    val availableIcons = listOf(
        Icons.Default.FitnessCenter,
        Icons.Default.DirectionsRun,
        Icons.Default.Favorite,
        Icons.Default.SelfImprovement
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Add Workout", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Workout Title") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = type,
            onValueChange = { type = it },
            label = { Text("Type") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = calories,
            onValueChange = { calories = it },
            label = { Text("Calories Burned") },
            modifier = Modifier.fillMaxWidth()
        )

        
        Text("Choose Icon", style = MaterialTheme.typography.bodyMedium)
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            availableIcons.forEach { icon ->
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(
                            if (selectedIcon == icon) Color(0xFF90CAF9) else Color.LightGray
                        )
                        .clickable { selectedIcon = icon },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    if (title.isNotBlank() && type.isNotBlank() && calories.isNotBlank()) {
                        onSave(
                            Activity(
                                icon = selectedIcon, // ambil dari pilihan user
                                nama = title,
                                effect = type,
                                calories = calories
                            )
                        )
                    }
                }
            ) {
                Text("Save Workout")
            }

            OutlinedButton(
                modifier = Modifier.weight(1f),
                onClick = onCancel
            ) {
                Text("Cancel")
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Soal2ExercisePreview() {
    Soal2Exercise()
}

