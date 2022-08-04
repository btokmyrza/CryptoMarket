package kz.btokmyrza.cryptomarket.data.mapper

import androidx.annotation.DrawableRes
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.data.remote.dto.CoinDto
import kz.btokmyrza.cryptomarket.domain.model.Coin
import kz.btokmyrza.cryptomarket.domain.model.CryptoCurrency

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol,
    )
}

fun Coin.toCryptoCurrency(): CryptoCurrency {
    return CryptoCurrency(
        name = name,
        alias = symbol,
        amount = rank.toString(),
        progress = isActive.toString(),
        imgId = R.drawable.img_xrp
    )
}
