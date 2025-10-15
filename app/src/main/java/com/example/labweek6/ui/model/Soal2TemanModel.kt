package com.example.labweek6.ui.model

data class Teman (
    val nama: String,
    val umur: String,
    var isFriend: Boolean,
    val tinggi: String,
    val berat: String,
    var jActivity: Int,
    var jTeman: Int
)

val listTeman = mutableListOf(
    Teman("Ian", "20", false, "170", "70", 0, 0),
    Teman("Yuriel", "20", false, "170", "70", 0, 0),
    Teman("Lui", "20", false, "170", "70", 0, 0),
    Teman("Eugene", "20", false, "170", "70", 0, 0),
    Teman("Rei", "20", false, "170", "70", 0, 0),
    Teman("Jae", "20", false, "170", "70", 0, 0),
    Teman("Owen", "20", false, "170", "70", 0, 0),
)


