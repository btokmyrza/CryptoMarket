package kz.btokmyrza.cryptomarket.data.mapper

import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.data.local.transaction.TransactionEntity
import kz.btokmyrza.cryptomarket.domain.model.Transaction
import kotlin.random.Random

fun TransactionEntity.toTransaction(): Transaction {
    return Transaction(
        id = id ?: Random.nextInt(),
        transactionAvatar = R.drawable.ic_money_transfer,
        transactionName = receiverPhoneNumber,
        transactionCardDetails = senderCardDetails,
        transactionAmount = amount
    )
}
