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
    val calories: String,
)

