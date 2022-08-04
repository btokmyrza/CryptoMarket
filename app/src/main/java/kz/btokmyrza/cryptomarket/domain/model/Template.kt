package kz.btokmyrza.cryptomarket.domain.model

import androidx.annotation.DrawableRes

data class Template(
    val id: Int,
    @DrawableRes val templateLogo: Int,
    val templateName: String,
    val templateAmount: String
)
