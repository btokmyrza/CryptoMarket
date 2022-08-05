package kz.btokmyrza.cryptomarket.data.mapper

import kz.btokmyrza.cryptomarket.domain.model.CryptoCurrency
import kz.btokmyrza.cryptomarket.domain.model.Watchlist

fun CryptoCurrency.map(): Watchlist =
    Watchlist(
        title = name,
        subtitle = alias,
        amount = amount,
        progress = progress,
        imgId = imgId
    )