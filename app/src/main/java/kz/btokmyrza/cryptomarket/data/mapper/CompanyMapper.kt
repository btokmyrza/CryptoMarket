package kz.btokmyrza.cryptomarket.data.mapper

import androidx.annotation.DrawableRes
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.data.local.stock.CompanyListingEntity
import kz.btokmyrza.cryptomarket.data.remote.dto.CompanyInfoDto
import kz.btokmyrza.cryptomarket.domain.model.CompanyInfo
import kz.btokmyrza.cryptomarket.domain.model.CompanyListing
import kz.btokmyrza.cryptomarket.domain.model.stocks.StockInfo
import kotlin.random.Random

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toStockInfo(): StockInfo {
    return StockInfo(
        id = Random.nextInt(),
        stockName = name,
        stockDirection = listOf(R.drawable.ic_trending_up, R.drawable.ic_trending_down).random(),
        stockSymbol = symbol,
    )
}

fun CompanyInfoDto.toCompanyInfo(): CompanyInfo {
    return CompanyInfo(
        symbol = symbol ?: "",
        description = description ?: "",
        name = name ?: "",
        country = country ?: "",
        industry = industry ?: ""
    )
}