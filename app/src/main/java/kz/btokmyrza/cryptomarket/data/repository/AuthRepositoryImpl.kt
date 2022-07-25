package kz.btokmyrza.cryptomarket.data.repository

import kz.btokmyrza.cryptomarket.data.local.auth.AuthDatabase
import kz.btokmyrza.cryptomarket.data.local.auth.AuthEntity
import kz.btokmyrza.cryptomarket.domain.repository.AuthRepository

class AuthRepositoryImpl(
    db: AuthDatabase
) : AuthRepository {

    private val authDao = db.dao

    override suspend fun login(
        email: String,
        password: String
    ): Boolean {
        val result = authDao.searchRegistrationData(email, password)
        if (result.isEmpty())
            return false
        return true
    }

    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Boolean {
        val result = authDao.searchEmail(email)
        if (result.isNotEmpty())
            return false

        authDao.insertRegistrationData(
            AuthEntity(
                name = name,
                email = email,
                password = password
            )
        )
        return true
    }

}