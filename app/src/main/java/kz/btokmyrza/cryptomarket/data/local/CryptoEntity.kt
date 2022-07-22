package kz.btokmyrza.cryptomarket.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "crypto")
data class CryptoEntity(
    @PrimaryKey var id: Int? = null
)
