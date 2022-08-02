package kz.btokmyrza.cryptomarket.domain.repository

import kotlinx.coroutines.flow.Flow
import kz.btokmyrza.cryptomarket.domain.model.CompanyInfo
import kz.btokmyrza.cryptomarket.domain.model.CompanyListing
import kz.btokmyrza.cryptomarket.domain.model.IntradayInfo
import kz.btokmyrza.cryptomarket.util.Resource

interface StockRepository {

    suspend fun getCompanyListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>>

    suspend fun getIntradayInfo(
        symbol: String,
    ): Resource<List<IntradayInfo>>

    suspend fun getCompanyInfo(
        symbol: String,
    ): Resource<CompanyInfo>

}