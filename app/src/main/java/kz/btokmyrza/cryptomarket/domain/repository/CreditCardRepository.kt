package kz.btokmyrza.cryptomarket.domain.repository

import kz.btokmyrza.cryptomarket.data.local.credit_card.CreditCardEntity

interface CreditCardRepository {

    suspend fun insertCreditCard(
        cardProvider: String,
        bankName: String,
        cardDetails: String,
        currentBalance: Float
    )

    suspend fun changeCreditCardBalance(
        changeAmount: Float,
        bankName: String
    )

    suspend fun getCreditCards(): List<CreditCardEntity>

}