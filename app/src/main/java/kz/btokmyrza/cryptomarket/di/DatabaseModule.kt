package kz.btokmyrza.cryptomarket.di

import androidx.room.Room
import kz.btokmyrza.cryptomarket.data.local.auth.AuthDatabase
import kz.btokmyrza.cryptomarket.data.local.crypto.CryptoDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            CryptoDatabase::class.java,
            "cryptodb.db"
        ).build()
    }

    single {
        Room.databaseBuilder(
            androidApplication(),
            AuthDatabase::class.java,
            "authdb.db"
        ).build()
    }

}