package kz.btokmyrza.cryptomarket.data.local.crypto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto")
data class CryptoEntity(
    @PrimaryKey val id: Int? = null
)
