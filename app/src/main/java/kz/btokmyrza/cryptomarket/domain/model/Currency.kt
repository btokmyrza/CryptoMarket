package kz.btokmyrza.cryptomarket.domain.model

import androidx.annotation.DrawableRes

data class Currency(val name: String, val amount: String, @DrawableRes val imgId: Int)
