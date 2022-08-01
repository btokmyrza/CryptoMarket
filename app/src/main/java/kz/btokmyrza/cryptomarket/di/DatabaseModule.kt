package kz.btokmyrza.cryptomarket.di

import androidx.room.Room
import kz.btokmyrza.cryptomarket.data.local.auth.AuthDatabase
import kz.btokmyrza.cryptomarket.data.local.stock.StockDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single<AuthDatabase> {
        Room.databaseBuilder(
            androidApplication(),
            AuthDatabase::class.java,
            "authdb.db"
        ).build()
    }

    single<StockDatabase> {
        Room.databaseBuilder(
            androidApplication(),
            StockDatabase::class.java,
            "stockdb.db"
        ).build()
    }

}