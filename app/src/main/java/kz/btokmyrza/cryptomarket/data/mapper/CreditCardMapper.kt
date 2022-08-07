package kz.btokmyrza.cryptomarket.data.mapper

import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.data.local.credit_card.CreditCardEntity
import kz.btokmyrza.cryptomarket.domain.model.CreditCard

fun CreditCardEntity.toCreditCard(): CreditCard {
    return CreditCard(
        id = id!!,
        providerLogo = if (cardProvider == "Visa") R.drawable.img_visa else R.drawable.img_master_card,
        bankName = bankName,
        cardDetails = cardDetails,
        moneyAmount = currentBalance.toString()
    )
}

fun CreditCardEntity.toStr(): String {
    return "$cardProvider \n $bankName ($${currentBalance}) \n $cardDetails"
}