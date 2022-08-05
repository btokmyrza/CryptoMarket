package kz.btokmyrza.cryptomarket.data.mapper

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
        progress = if (isActive) "Active" else "Inactive",
        imgId = getCryptoLogo(symbol)
    )
}

fun getCryptoLogo(symbol: String): Int {
    return when (symbol) {
        "BTC" -> R.drawable.img_bitcoin
        "ETH" -> R.drawable.img_ethereum
        "USDT" -> R.drawable.img_tether
        "XRP" -> R.drawable.img_xrp
        "BCH" -> R.drawable.img_bitcoin_cash
        "LTC" -> R.drawable.img_ltc
        "ADA" -> R.drawable.img_cardane
        "WAVES" -> R.drawable.img_waves
        else -> R.drawable.ic_generic_cryptocurrency_yellow
    }
}
