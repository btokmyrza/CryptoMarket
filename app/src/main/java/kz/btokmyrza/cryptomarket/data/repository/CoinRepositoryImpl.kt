package kz.btokmyrza.cryptomarket.data.repository

import kz.btokmyrza.cryptomarket.data.remote.CoinPaprikaApi
import kz.btokmyrza.cryptomarket.data.remote.dto.CoinDto
import kz.btokmyrza.cryptomarket.domain.repository.CoinRepository

class CoinRepositoryImpl(
    val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

}