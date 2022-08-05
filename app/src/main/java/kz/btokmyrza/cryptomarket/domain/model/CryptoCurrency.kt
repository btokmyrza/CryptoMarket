package kz.btokmyrza.cryptomarket.domain.model

import androidx.annotation.DrawableRes
import java.io.Serializable

data class CryptoCurrency(
    val name: String,
    val alias: String,
    val amount: String,
    val progress: String,
    @DrawableRes val imgId: Int
): Serializable
