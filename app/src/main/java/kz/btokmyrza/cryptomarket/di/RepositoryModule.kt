package kz.btokmyrza.cryptomarket.di

import kz.btokmyrza.cryptomarket.data.csv.CSVParser
import kz.btokmyrza.cryptomarket.data.csv.CompanyListingsParser
import kz.btokmyrza.cryptomarket.data.csv.IntradayInfoParser
import kz.btokmyrza.cryptomarket.data.repository.AuthRepositoryImpl
import kz.btokmyrza.cryptomarket.data.repository.CoinRepositoryImpl
import kz.btokmyrza.cryptomarket.data.repository.StockRepositoryImpl
import kz.btokmyrza.cryptomarket.data.repository.TransactionsRepositoryImpl
import kz.btokmyrza.cryptomarket.domain.model.CompanyListing
import kz.btokmyrza.cryptomarket.domain.model.IntradayInfo
import kz.btokmyrza.cryptomarket.domain.repository.AuthRepository
import kz.btokmyrza.cryptomarket.domain.repository.CoinRepository
import kz.btokmyrza.cryptomarket.domain.repository.StockRepository
import kz.btokmyrza.cryptomarket.domain.repository.TransactionsRepository
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {

    single<CSVParser<CompanyListing>>(named("CompanyListing")) {
        CompanyListingsParser()
    } bind CSVParser::class

    single<CSVParser<IntradayInfo>>(named("IntradayInfo")) {
        IntradayInfoParser()
    } bind CSVParser::class

    single<AuthRepository> {
        AuthRepositoryImpl(db = get())
    }

    single<TransactionsRepository> {
        TransactionsRepositoryImpl(db = get())
    }

    single<CoinRepository> {
        CoinRepositoryImpl(api = get())
    }

    single<StockRepository> {
        StockRepositoryImpl(
            api = get(),
            db = get(),
            companyListingsParser = get(named("CompanyListing")),
            intradayInfoParser = get(named("IntradayInfo"))
        )
    }

}