package kz.btokmyrza.cryptomarket.data.local.transaction

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(
        transaction: TransactionEntity
    )

    @Query("SELECT * FROM transactionentity")
    suspend fun getTransactions(): List<TransactionEntity>

    @Query("DELETE FROM transactionentity")
    suspend fun clearTransactions()

}