package kz.btokmyrza.cryptomarket.data.local.auth

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [AuthEntity::class],
    version = 1
)
abstract class AuthDatabase : RoomDatabase() {

    abstract val dao: AuthDao

}