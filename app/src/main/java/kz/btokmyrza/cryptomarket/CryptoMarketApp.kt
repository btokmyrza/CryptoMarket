package kz.btokmyrza.cryptomarket

import android.app.Application
import kz.btokmyrza.cryptomarket.di.appModule
import kz.btokmyrza.cryptomarket.di.databaseModule
import kz.btokmyrza.cryptomarket.di.networkModule
import kz.btokmyrza.cryptomarket.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CryptoMarketApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CryptoMarketApp)
            modules(appModule, networkModule, databaseModule, repositoryModule)
        }
    }

}