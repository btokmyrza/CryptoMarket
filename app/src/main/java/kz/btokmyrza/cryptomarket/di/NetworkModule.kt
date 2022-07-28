package kz.btokmyrza.cryptomarket.di

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.data.remote.CryptoApi
import kz.btokmyrza.cryptomarket.data.remote.StockApi
import kz.btokmyrza.cryptomarket.util.Constants.BASE_URL
import kz.btokmyrza.cryptomarket.util.Constants.STOCKS_API_BASE_URL
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {

    single {
        Glide.with(androidApplication()).setDefaultRequestOptions(
            RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
        )
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }

    single {
        Retrofit.Builder()
            .baseUrl(STOCKS_API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(StockApi::class.java)
    }

}