package kz.btokmyrza.cryptomarket.util

import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.domain.model.CreditCard
import kz.btokmyrza.cryptomarket.domain.model.Template
import kz.btokmyrza.cryptomarket.domain.model.Transaction

object Constants {

    // Shared preferences for currently logged in user
    const val CURRENT_USER = "CURRENT_USER"

    // Stocks API
    const val STOCKS_API_KEY = "2UYHJ3S01RGB24O8"
    const val STOCKS_API_BASE_URL = "https://www.alphavantage.co/"

    // Crypto API
    const val CRYPTO_API_BASE_URL = "https://api.coinpaprika.com/v1/"

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

    val TEMPLATES = listOf(
        Template(
            id = 0,
            templateLogo = R.drawable.template_phone,
            templateName = "Phone",
            templateAmount = "$15.00"
        ),
        Template(
            id = 1,
            templateLogo = R.drawable.template_internet,
            templateName = "Internet",
            templateAmount = "$50.00"
        ),
        Template(
            id = 2,
            templateLogo = R.drawable.template_john,
            templateName = "John",
            templateAmount = "$270.00"
        ),
        Template(
            id = 3,
            templateLogo = R.drawable.template_house_rent,
            templateName = "House Rent",
            templateAmount = "$2500.00"
        ),
    )
}