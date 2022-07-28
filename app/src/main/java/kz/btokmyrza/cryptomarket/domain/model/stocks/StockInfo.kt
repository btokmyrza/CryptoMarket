package kz.btokmyrza.cryptomarket.domain.model.stocks

import androidx.annotation.DrawableRes

data class StockInfo(
    val id: Int,
    val stockName: String,
    @DrawableRes val stockDirection: Int,
    val stockChangeAmount: String,
) : StockItem
