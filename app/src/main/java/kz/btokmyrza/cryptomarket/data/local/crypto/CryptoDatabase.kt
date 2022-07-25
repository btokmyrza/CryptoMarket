package kz.btokmyrza.cryptomarket.data.local.crypto

import androidx.room.Database
import androidx.room.RoomDatabase
import kz.btokmyrza.cryptomarket.data.local.auth.AuthEntity

@Database(
    entities = [CryptoEntity::class],
    version = 1
)
abstract class CryptoDatabase : RoomDatabase() {

    abstract val dao: CryptoDao

}