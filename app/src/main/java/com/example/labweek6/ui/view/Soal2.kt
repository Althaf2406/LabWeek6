package com.example.labweek6.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.labweek6.ui.viewmodel.Soal2ViewModel
import com.example.labweek6.ui.model.listTeman

@Composable
fun Soal2(
    s2VM: Soal2ViewModel = viewModel(),
    modifier: Modifier = Modifier,
    navController: NavController = rememberNavController()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        ProfileCard(prfl = s2VM.user.value)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Recently Added")
        Spacer(modifier = Modifier.height(8.dp))
        Column (
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
        ) {
            val temanYangSudahDitambah = listTeman.filter { it.isFriend }

            Spacer(modifier = Modifier.height(8.dp))

            if (temanYangSudahDitambah.isNotEmpty()) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    temanYangSudahDitambah.forEach { teman ->
                        FriendCard(
                            tMN = teman,
                            modifier = Modifier,
                            onAddFriend = { s2VM.addFriend(it) }
                        )
                    }
                }
            } else {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No Friends yet.", color = Color.Gray)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Recent Workouts")
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Spacer(modifier = Modifier.height(8.dp))

            if (s2VM.aCTVPublic.isNotEmpty()) {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    s2VM.aCTVPublic.forEach { akt ->
                        val displayAkt = akt.copy(isActivess = true)
                        ExerciseCard(
                            akt = displayAkt,
                            modifier = Modifier,
                            onToggleClick = { s2VM.removeActivity(akt) }
                        )
                    }
                }
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No Workouts yet", color = Color.Gray)
                }
            }

        }

    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Soal2Preview() {
    Soal2()
}
