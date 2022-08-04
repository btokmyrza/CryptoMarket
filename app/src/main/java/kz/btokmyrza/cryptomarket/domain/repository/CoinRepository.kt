package kz.btokmyrza.cryptomarket.domain.repository

import kz.btokmyrza.cryptomarket.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

}