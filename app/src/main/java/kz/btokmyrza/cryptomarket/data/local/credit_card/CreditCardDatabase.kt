package kz.btokmyrza.cryptomarket.data.local.credit_card

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CreditCardEntity::class],
    version = 1
)
abstract class CreditCardDatabase : RoomDatabase() {
    abstract val dao: CreditCardDao
}