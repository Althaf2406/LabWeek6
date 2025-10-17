package com.example.labweek6.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labweek6.R
import com.example.labweek6.ui.model.listProduk
import com.example.labweek6.ui.viewmodel.Soal1ViewModel
import kotlin.collections.chunked
import kotlin.collections.forEach

@Composable
fun Soal1Pandamart(
    s1VM: Soal1ViewModel = viewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD9D9D9))
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Find Your\nFavourite Vegetables",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF222222)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                        .height(48.dp)
                        .background(Color(0xFFC64B8F), RoundedCornerShape(50))
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Filled.Search, contentDescription = null, tint = Color.White)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Search for Vegetables",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Featured products", fontWeight = FontWeight.Bold)
                Text("View More", color = Color(0xFFC64B8F))
            }

            Spacer(modifier = Modifier.height(16.dp))

            val rows = listProduk
                .filter { !it.isFood && it.isVege }
                .chunked(2)
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                items(rows) { pair ->
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        pair.forEach { pRDK ->
                            ProdukCard(
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .weight(1f),
                                pRDK = pRDK,
                            )
                        }
                        if (pair.size == 1) {
                            Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                }
            }

        }

        Spacer(modifier = Modifier.height(16.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(16.dp))
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable._3ce81b227e955ca1a2ebef66188dbfd672174f6), // ganti dgn gambar kamu
                contentDescription = "Promo Background",
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .size(2000.dp)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(bottom = 50.dp, start = 75.dp, end = 150.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "20% off on your first purchase",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .height(3.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFF00C853)) // hijau
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    repeat(3) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray)
                        )
                        if (it != 2) Spacer(modifier = Modifier.width(6.dp))
                    }
                }
            }
        }
    }
}


@Composable
@Preview
fun Soal1PandamartPreview() {
    Soal1Pandamart()
}
