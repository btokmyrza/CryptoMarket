package kz.btokmyrza.cryptomarket.data.local.transaction

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TransactionEntity::class],
    version = 1
)
abstract class TransactionDatabase : RoomDatabase() {

    abstract val dao: TransactionDao

}