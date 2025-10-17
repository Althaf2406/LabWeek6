package com.example.labweek6.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.labweek6.ui.model.Activity
import com.example.labweek6.ui.model.Teman


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
    }

    val aCTVPublic : List<Activity> = aCTV


    fun addActivity(newActivity: Activity) {
        aCTV.add(newActivity)
        updateActivityCount()
    }


    fun removeActivity(activity: Activity) {
        aCTV.remove(activity)
        updateActivityCount()
    }

    private fun updateActivityCount() {
        user.value = user.value.copy(jActivity = aCTV.size)
    }
    fun addFriend(teman: Teman) {
        if (!teman.isFriend) {
            teman.isFriend = true
            user.value = user.value.copy(jTeman = user.value.jTeman + 1)
        }
    }
}
