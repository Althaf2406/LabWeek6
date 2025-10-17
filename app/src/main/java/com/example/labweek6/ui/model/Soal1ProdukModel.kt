package com.example.labweek6.ui.model

import com.example.labweek6.R
import com.example.labweek6.ui.view.ProfileCard

data class Produk(
    var nama: String,
    var harga: String,
    var gambar: Int,
    val isFood: Boolean = false,
    val isVege: Boolean = false
)

val listProduk = mutableListOf(
    Produk("Fresh Peach", "9$", R.drawable._34602436bf5d80d9b44d264b81647e006dd74ec, isVege = true ),
    Produk("Avocado", "7$", R.drawable.a92debe4995aba9410f35a3fbaa104adc2a8a0f9, isVege = true),
    Produk("Pineapple", "5$", R.drawable._a087b50bdce6279eee31780533f3443f595dff7, isVege = true),
    Produk("Brocoli", "3", R.drawable._7ed4ca90202299aabeb5ef33ad7a92d66ec530f, isVege = true),
    Produk("Zinger Burger", "2$", R.drawable.group_21, isFood = true),
    Produk("Roll Paratha","3$", R.drawable._c9f92d7d224f5aa0939f86ab73367afb5d0c356, isFood = true),
    Produk("Tomatto Soup", "2$", R.drawable._db76dcaff64d52ff299a11e203adfc4913e4b67, isFood = true),
    Produk("Long Burger", "5$", R.drawable.fd9ed09984d7dcd6a9704932907c19b93862f420,  isFood = true),
    Produk("Creamy Biscuit", "5$", R.drawable.ef7e5f2b7f4adb4235e2219c9a0eca69f097473c, isFood = true),
    Produk("Roll Paratha", "3$", R.drawable.d49ec7e7a7f143a91606e9b34b690beb251bfea3, isFood = true)
    )




