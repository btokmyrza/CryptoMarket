package kz.btokmyrza.cryptomarket.domain.repository

import kz.btokmyrza.cryptomarket.data.local.transaction.TransactionEntity

interface TransactionsRepository {

    suspend fun insertTransaction(
        phoneNumber: String,
        cardDetails: String,
        amount: String
    )

    suspend fun getTransactions(): List<TransactionEntity>

}