package kz.btokmyrza.cryptomarket.data.local.auth

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AuthDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertRegistrationData(
        registrationData: AuthEntity
    )

    @Query("SELECT * FROM auth WHERE email=:emailQuery AND password=:passwordQuery")
    suspend fun searchRegistrationData(
        emailQuery: String,
        passwordQuery: String
    ): List<AuthEntity>

    @Query("SELECT * FROM auth WHERE email=:emailQuery")
    suspend fun searchEmail(emailQuery: String): List<AuthEntity>

}
