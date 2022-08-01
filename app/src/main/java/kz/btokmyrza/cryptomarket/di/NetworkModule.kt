package kz.btokmyrza.cryptomarket.di

import kz.btokmyrza.cryptomarket.data.remote.StockApi
import kz.btokmyrza.cryptomarket.util.Constants.STOCKS_API_BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(STOCKS_API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(StockApi::class.java)
    }

}