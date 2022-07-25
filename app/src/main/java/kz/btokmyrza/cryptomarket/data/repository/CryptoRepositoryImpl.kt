package kz.btokmyrza.cryptomarket.data.repository

import kz.btokmyrza.cryptomarket.data.local.crypto.CryptoDatabase
import kz.btokmyrza.cryptomarket.data.remote.CryptoApi
import kz.btokmyrza.cryptomarket.domain.repository.CryptoRepository

class CryptoRepositoryImpl(
    private val api: CryptoApi,
    db: CryptoDatabase,
) : CryptoRepository {



}