package kz.btokmyrza.cryptomarket.data.local.credit_card

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CreditCardEntity(
    @PrimaryKey
    val id: Int? = null,
    val cardProvider: String,
    val bankName: String,
    val cardDetails: String,
    val currentBalance: Float
)