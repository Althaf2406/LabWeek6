package com.example.labweek6.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.labweek6.ui.model.Activity
import com.example.labweek6.ui.model.Teman
import com.example.labweek6.ui.model.listTeman

@Composable
fun FriendCard(
    tMN: Teman,
    modifier: Modifier = Modifier,
    addFriend: (Teman) -> Unit,
    removeFriend: (Teman) -> Unit = {},
) {
    Column(
        modifier = modifier
            .width(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFE0F7FA))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(Color(0xFFDFF3F8)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile",
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
        Text(tMN.nama, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text("${tMN.umur} years old", color = Color.Gray, fontSize = 14.sp)

        Spacer(modifier = Modifier.height(12.dp))

        if (!tMN.isActivess){
            Button(
                onClick = {
                    if (tMN.isFriend == false) {
                        addFriend(tMN)
                    } else {
                        removeFriend(tMN)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (tMN.isFriend) Color(0xFFEF5350) else Color(0xFF2196F3),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .width(130.dp)
                    .height(36.dp)
            ) {
                Text(if (tMN.isFriend) "Unfriend" else "Add Friend")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FriendCardPreview() {
    FriendCard(
        tMN = listTeman[0],
        modifier = Modifier,
        addFriend = {},
        removeFriend = {},
    )
}