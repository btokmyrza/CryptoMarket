package kz.btokmyrza.cryptomarket.data.mapper

import kz.btokmyrza.cryptomarket.data.remote.dto.CoinDto
import kz.btokmyrza.cryptomarket.domain.model.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol,
    )
}
