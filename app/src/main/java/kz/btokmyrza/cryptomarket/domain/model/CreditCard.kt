package kz.btokmyrza.cryptomarket.domain.model

import androidx.annotation.DrawableRes

data class CreditCard(
    val id: Int,
    @DrawableRes val providerLogo: Int,
    val bankName: String,
    val cardDetails: String,
    val moneyAmount: String
)
