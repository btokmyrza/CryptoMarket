package kz.btokmyrza.cryptomarket.data.local.transaction

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TransactionEntity(
    @PrimaryKey
    val id: Int? = null,
    val phoneNumber: String,
    val cardDetails: String,
    val amount: String
)