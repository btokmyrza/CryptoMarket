package kz.btokmyrza.cryptomarket.util

import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.domain.model.CreditCard
import kz.btokmyrza.cryptomarket.domain.model.Transaction
import kz.btokmyrza.cryptomarket.domain.model.stocks.StockAdd
import kz.btokmyrza.cryptomarket.domain.model.stocks.StockInfo

object Constants {

    // HEADER PARAMETER NAME: X-RapidAPI-Key
    const val API_KEY = "c552648734msh96ed9a0191d2f75p1fefc8jsn8194bab9a883"
    // HEADER PARAMETER NAME: X-RapidAPI-Host
    const val API_HOST = "coinranking1.p.rapidapi.com"
    const val BASE_URL = "https://coinranking1.p.rapidapi.com/"

    // Stocks API
    const val STOCKS_API_KEY = "XTH5Q3Q3ETE1H9P2"
    const val STOCKS_API_BASE_URL = "https://www.alphavantage.co/"

    val CREDIT_CARDS = listOf(
        CreditCard(
            id = 0,
            providerLogo = R.drawable.img_master_card,
            bankName = "Nord Bank",
            cardDetails = "Mastercard • 7682",
            moneyAmount = "$5 870.00"
        ),
        CreditCard(
            id = 1,
            providerLogo = R.drawable.img_visa,
            bankName = "Amazon",
            cardDetails = "Visa • 8245",
            moneyAmount = "$5 870.00"
        ),
    )

    val STOCK_ITEMS = listOf(
        StockAdd(id = 0),
        StockInfo(
            id = 1,
            stockName = "USD",
            stockDirection = R.drawable.ic_trending_up,
            stockChangeAmount = "+1.56%"
        ),
        StockInfo(
            id = 2,
            stockName = "BTC",
            stockDirection = R.drawable.ic_trending_down,
            stockChangeAmount = "-1.08%"
        ),
        StockInfo(
            id = 3,
            stockName = "AAPL",
            stockDirection = R.drawable.ic_trending_up,
            stockChangeAmount = "+1.24%"
        )
    )

    val TRANSACTIONS = listOf(
        Transaction(
            id = 0,
            transactionAvatar = R.drawable.avatar_alan_denver,
            transactionName = "Alan Denver",
            transactionCardDetails = "Mastercard • 7682",
            transactionAmount = "+$280.00"
        ),
        Transaction(
            id = 1,
            transactionAvatar = R.drawable.avatar_airline_ticket,
            transactionName = "Airline Ticket",
            transactionCardDetails = "Mastercard • 7682",
            transactionAmount = "+$280.00"
        ),
        Transaction(
            id = 2,
            transactionAvatar = R.drawable.avatar_house_rent,
            transactionName = "House Rent",
            transactionCardDetails = "Visa • 8245",
            transactionAmount = "-$2 500.00"
        ),
        Transaction(
            id = 3,
            transactionAvatar = R.drawable.avatar_anna_enfield,
            transactionName = "Anna Enfield",
            transactionCardDetails = "Mastercard • 7682",
            transactionAmount = "-$700.00"
        ),
        Transaction(
            id = 4,
            transactionAvatar = R.drawable.avatar_coffee_street_3b,
            transactionName = "Coffee Street 3B",
            transactionCardDetails = "Visa • 8245",
            transactionAmount = "-$12.00"
        ),
        Transaction(
            id = 5,
            transactionAvatar = R.drawable.avatar_cos,
            transactionName = "COS",
            transactionCardDetails = "Mastercard • 7682",
            transactionAmount = "-$200.00"
        ),
        Transaction(
            id = 6,
            transactionAvatar = R.drawable.avatar_spotify,
            transactionName = "Spotify",
            transactionCardDetails = "Visa • 8245",
            transactionAmount = "-$10.00"
        ),
        Transaction(
            id = 7,
            transactionAvatar = R.drawable.avatar_john_chester,
            transactionName = "John Chester",
            transactionCardDetails = "Mastercard • 7682",
            transactionAmount = "+$1 200.00"
        )
    )

}