package kz.btokmyrza.cryptomarket

import android.app.Application
import kz.btokmyrza.cryptomarket.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CryptoMarketApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@CryptoMarketApp)
            modules(appModule)
        }
    }

}