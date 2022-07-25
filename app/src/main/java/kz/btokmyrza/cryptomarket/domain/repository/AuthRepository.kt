package kz.btokmyrza.cryptomarket.domain.repository

interface AuthRepository {

    suspend fun login(
        email: String,
        password: String
    ): Boolean

    suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Boolean

}