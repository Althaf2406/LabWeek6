package com.example.labweek6.ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.RiceBowl
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.labweek6.R

data class Activity (
    val icon: ImageVector,
    val nama: String,
    val effect: String,
    var isActive: Boolean
)

val listAktivitas = mutableListOf(
    Activity(Icons.Filled.DirectionsRun,"Cardio Blast", "Cardio", false, ),
    Activity(Icons.Filled.SelfImprovement ,"Morning Yoga", "Flexibility", false),
    Activity(Icons.Filled.SelfImprovement ,"Mindfulness Meditation", "Mindfulness", false),
    Activity(Icons.Filled.RiceBowl  ,"Healthy Eating", "Nutrition", false, ),
    Activity(Icons.Filled.FitnessCenter,"Strength Training", "Strength", false,),
    Activity(Icons.Filled.DirectionsRun ,"Evening Run", "Cardio", false, ),
)
