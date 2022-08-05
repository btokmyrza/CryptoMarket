package kz.btokmyrza.cryptomarket.data.repository

import kz.btokmyrza.cryptomarket.data.local.transaction.TransactionDatabase
import kz.btokmyrza.cryptomarket.data.local.transaction.TransactionEntity
import kz.btokmyrza.cryptomarket.domain.repository.TransactionsRepository

class TransactionsRepositoryImpl(
    db: TransactionDatabase
) : TransactionsRepository {

    private val transactionDao = db.dao

    override suspend fun insertTransaction(
        phoneNumber: String,
        cardDetails: String,
        amount: String
    ) {
        transactionDao.insertTransaction(
            TransactionEntity(
                phoneNumber = phoneNumber,
                cardDetails = cardDetails,
                amount = amount
            )
        )
    }

    override suspend fun getTransactions(): List<TransactionEntity> {
        return transactionDao.getTransactions()
    }
}