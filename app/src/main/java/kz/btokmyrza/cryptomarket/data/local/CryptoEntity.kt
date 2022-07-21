package kz.btokmyrza.cryptomarket.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CryptoEntity(
    @PrimaryKey val id: Int? = null
)
