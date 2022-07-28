package kz.btokmyrza.cryptomarket.data.remote

import kz.btokmyrza.cryptomarket.data.remote.dto.CompanyInfoDto
import kz.btokmyrza.cryptomarket.util.Constants.STOCKS_API_KEY
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface StockApi {

    @GET("query")
    suspend fun getListings(
        @Query("function") function: String = "LISTING_STATUS",
        @Query("apikey") apiKey: String = STOCKS_API_KEY
    ): ResponseBody

    @GET("query")
    suspend fun getIntradayInfo(
        @Query("function") function: String = "TIME_SERIES_INTRADAY",
        @Query("interval") interval: String = "60min",
        @Query("datatype") datatype: String = "csv",
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = STOCKS_API_KEY
    ): ResponseBody

    @GET("query")
    suspend fun getCompanyInfo(
        @Query("function") function: String = "OVERVIEW",
        @Query("symbol") symbol: String,
        @Query("apikey") apiKey: String = STOCKS_API_KEY
    ): CompanyInfoDto

}