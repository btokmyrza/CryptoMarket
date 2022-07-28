package kz.btokmyrza.cryptomarket.domain.model

import androidx.annotation.DrawableRes

data class Transaction(
    val id: Int,
    @DrawableRes val transactionAvatar: Int,
    val transactionName: String,
    val transactionCardDetails: String,
    val transactionAmount: String
)
