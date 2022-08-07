package kz.btokmyrza.cryptomarket.data.repository

import kz.btokmyrza.cryptomarket.data.local.credit_card.CreditCardDatabase
import kz.btokmyrza.cryptomarket.data.local.credit_card.CreditCardEntity
import kz.btokmyrza.cryptomarket.domain.repository.CreditCardRepository

class CreditCardRepositoryImpl(
    db: CreditCardDatabase
) : CreditCardRepository {

    private val creditCardDao = db.dao

    override suspend fun insertCreditCard(
        cardProvider: String,
        bankName: String,
        cardDetails: String,
        currentBalance: Float
    ) {
        creditCardDao.insertCreditCard(
            CreditCardEntity(
                cardProvider = cardProvider,
                bankName = bankName,
                cardDetails = cardDetails,
                currentBalance = currentBalance
            )
        )
    }

    override suspend fun changeCreditCardBalance(changeAmount: Float, bankName: String) {
        creditCardDao.changeCreditCardBalance(changeAmount, bankName)
    }

    override suspend fun getCreditCards(): List<CreditCardEntity> {
        return creditCardDao.getCreditCards()
    }

}