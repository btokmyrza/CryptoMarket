package kz.btokmyrza.cryptomarket.di

import kz.btokmyrza.cryptomarket.data.repository.AuthRepositoryImpl
import kz.btokmyrza.cryptomarket.domain.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {



    single<AuthRepository> {
        AuthRepositoryImpl(db = get())
    }

}