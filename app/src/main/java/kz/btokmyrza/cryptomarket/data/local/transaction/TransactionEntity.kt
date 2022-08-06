package kz.btokmyrza.cryptomarket.data.local.transaction

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TransactionEntity(
    @PrimaryKey
    val id: Int? = null,
    val receiverPhoneNumber: String,
    val senderCardDetails: String,
    val amount: String
)