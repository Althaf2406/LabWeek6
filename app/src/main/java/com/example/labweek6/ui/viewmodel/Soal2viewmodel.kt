package com.example.labweek6.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.labweek6.ui.model.Activity
import com.example.labweek6.ui.model.Teman
import com.example.labweek6.ui.model.listAktivitas

class Soal2ViewModel : ViewModel() {
    var user = mutableStateOf(
        Teman(
            nama = "Althaf",
            umur = "19",
            isFriend = false,
            tinggi = "160",
            berat = "120",
            jActivity = 0,
            jTeman = 0
        )
    )

    private val aCTV = mutableStateListOf<Activity>().apply {
        addAll(listAktivitas)
    }
    val activities: List<Activity> = aCTV

    fun toggleActivity(activity: Activity) {
        val index = aCTV.indexOf(activity)
        if (index != -1) {
            aCTV[index] = aCTV[index].copy(
                isActive = !aCTV[index].isActive
            )
            val activeCount = aCTV.count { it.isActive }
            user.value = user.value.copy(jActivity = activeCount)
        }
    }

    fun addFriend(teman: Teman) {
        if (!teman.isFriend) {
            teman.isFriend = true
            user.value = user.value.copy(jTeman = user.value.jTeman + 1)
        }
    }
}