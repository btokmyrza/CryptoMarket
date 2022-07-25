package kz.btokmyrza.cryptomarket.di

import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.data.local.crypto.CryptoDatabase
import kz.btokmyrza.cryptomarket.data.remote.CryptoApi
import kz.btokmyrza.cryptomarket.data.repository.AuthRepositoryImpl
import kz.btokmyrza.cryptomarket.domain.repository.AuthRepository
import kz.btokmyrza.cryptomarket.presentation.auth.login.LoginViewModel
import kz.btokmyrza.cryptomarket.presentation.auth.sign_up.SignUpViewModel
import kz.btokmyrza.cryptomarket.util.Constants.BASE_URL
import kz.btokmyrza.cryptomarket.util.DispatcherProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

}