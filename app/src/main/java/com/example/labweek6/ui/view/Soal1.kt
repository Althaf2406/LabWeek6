package com.example.labweek6.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.room.util.copy
import com.example.labweek6.R
import com.example.labweek6.ui.viewmodel.Soal2ViewModel
import com.example.labweek6.ui.model.listTeman

@Composable
fun Soal1(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(top = 30.dp, start = 8.dp, end = 8.dp, bottom = 16.dp)
    ) {
        Row {
            Column (
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .weight(0.5f)
            ){
                Text(
                    "Taste the world at your Door Step!",
                    fontSize = 25.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .weight(0.5f)

            ) {
                Image(
                    painter = painterResource(R.drawable.ellipse_1),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(70.dp)

                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("What are you craving?") },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFD75AA3), shape = RoundedCornerShape(50.dp)),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.White
                    )
                },
            )

            // Tabs (Restaurants, Deals, Track Order)
            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD75AA3)),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text("Restaurants", color = Color.White)
                }

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE1BEE7)),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text("Deals", color = Color(0xFF9C27B0))
                }

                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE1BEE7)),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text("Track Order", color = Color(0xFF9C27B0))
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Card(
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text("Food delivery")
                    Text("Delivery from 99 $")
                }
            }
            Card(
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Text("Pandamart")
                    Text("New users $10 off")
                }
            }
        }
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Soal1Preview(){
    Soal1()
}