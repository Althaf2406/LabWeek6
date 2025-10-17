package com.example.labweek6.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labweek6.ui.model.Activity

@Composable
fun ExerciseCard(
    modifier: Modifier,
    onToggleClick: (Activity) -> Unit,
    akt: Activity,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFE8F6E9))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFB2DFDB)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = akt.icon,
                    contentDescription = akt.nama,
                    tint = Color.Black,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(akt.nama, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(akt.effect, fontSize = 14.sp, color = Color.Gray)
            }
        }
        if (!akt.isActivess) {
            Icon(
                imageVector = Icons.Default.Remove,
                contentDescription = "Remove",
                tint = Color.White,
                modifier = Modifier
                    .size(28.dp)
                    .background(
                        Color.Red,
                        shape = CircleShape
                    )
                    .clickable {
                        onToggleClick(akt)
                    }
            )
        }

    }
}

@Composable
@Preview(showBackground = true)
fun ExerciseCardPreview() {
    ExerciseCard(

        modifier = Modifier,
        onToggleClick = {},
        akt = Activity(
            icon = Icons.Default.Add,
            nama = "Running",
            effect = "Cardio",
            calories = "200",
        )
    )
}