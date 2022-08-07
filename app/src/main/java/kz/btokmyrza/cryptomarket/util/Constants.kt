package kz.btokmyrza.cryptomarket.util

import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.domain.model.CreditCard
import kz.btokmyrza.cryptomarket.domain.model.Template

object Constants {

    // Shared preferences for currently logged in user
    const val CURRENT_USER = "CURRENT_USER"

    // Pay bottomsheet arguments
    const val PHONE_NUMBER = "PHONE_NUMBER"
    const val NAME = "NAME"
    const val AMOUNT = "AMOUNT"

    // Stocks API
    const val STOCKS_API_KEY = "2UYHJ3S01RGB24O8"
    const val STOCKS_API_BASE_URL = "https://www.alphavantage.co/"

    // Crypto API
    const val CRYPTO_API_BASE_URL = "https://api.coinpaprika.com/v1/"

    val CREDIT_CARDS = listOf(
        CreditCard(
            id = 0,
            providerLogo = R.drawable.ic_no_credit_cards,
            bankName = "No credit",
            cardDetails = " cards added",
            moneyAmount = ""
        ),
    )

    val TEMPLATES = listOf(
        Template(
            id = 0,
            templateLogo = R.drawable.template_phone,
            templateName = "Phone",
            templateAmount = "15.00"
        ),
        Template(
            id = 1,
            templateLogo = R.drawable.template_internet,
            templateName = "Internet",
            templateAmount = "50.00"
        ),
        Template(
            id = 2,
            templateLogo = R.drawable.template_john,
            templateName = "John",
            templateAmount = "270.00"
        ),
        Template(
            id = 3,
            templateLogo = R.drawable.template_house_rent,
            templateName = "House Rent",
            templateAmount = "2500.00"
        ),
    )
}