package kz.btokmyrza.cryptomarket.presentation.tabs.trade

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kz.btokmyrza.cryptomarket.data.mapper.toCoin
import kz.btokmyrza.cryptomarket.domain.model.Coin
import kz.btokmyrza.cryptomarket.domain.repository.CoinRepository
import kz.btokmyrza.cryptomarket.util.Resource
import retrofit2.HttpException
import java.io.IOException

class TradeViewModel(
    private val repository: CoinRepository
) : ViewModel() {

    private val _coins = MutableLiveData<List<Coin>>()
    val coins: LiveData<List<Coin>> = _coins

    init {
        getCoins()
    }

    private fun getCoinsUseCase(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server"))
        }
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> _coins.postValue(result.data ?: emptyList())
                is Resource.Error -> Unit
                is Resource.Loading -> Unit
            }
        }.launchIn(viewModelScope)
    }

}