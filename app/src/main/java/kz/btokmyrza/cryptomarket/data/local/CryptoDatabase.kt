package kz.btokmyrza.cryptomarket.data.local

import androidx.room.Database

@Database(
    entities = [CryptoEntity::class],
    version = 1
)
abstract class CryptoDatabase {

    abstract val dao: CryptoDao

}