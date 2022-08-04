package kz.btokmyrza.cryptomarket.data.remote

import kz.btokmyrza.cryptomarket.data.remote.dto.CoinDto
import retrofit2.http.GET

interface CoinPaprikaApi {

    @GET("coins")
    suspend fun getCoins(): List<CoinDto>

}