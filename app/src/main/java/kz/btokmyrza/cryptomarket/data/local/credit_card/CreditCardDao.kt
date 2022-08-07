package kz.btokmyrza.cryptomarket.data.local.credit_card

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CreditCardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCreditCard(
        creditCard: CreditCardEntity
    )

    @Query("UPDATE creditcardentity SET currentBalance=currentBalance+:changeAmount WHERE bankName=:bankName")
    suspend fun changeCreditCardBalance(
        changeAmount: Float,
        bankName: String
    )

    @Query("SELECT * FROM creditcardentity")
    suspend fun getCreditCards(): List<CreditCardEntity>

    @Query("DELETE FROM creditcardentity")
    suspend fun clearCreditCards()

}