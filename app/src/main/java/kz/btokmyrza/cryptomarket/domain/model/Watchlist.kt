package kz.btokmyrza.cryptomarket.domain.model

import androidx.annotation.DrawableRes

data class Watchlist(
    val title: String,
    val subtitle: String,
    val amount: String,
    val progress: String,
    @DrawableRes val imgId: Int
)
