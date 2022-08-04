package kz.btokmyrza.cryptomarket.presentation.tabs.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.btokmyrza.cryptomarket.data.mapper.toStockInfo
import kz.btokmyrza.cryptomarket.domain.model.CreditCard
import kz.btokmyrza.cryptomarket.domain.model.Transaction
import kz.btokmyrza.cryptomarket.domain.model.stocks.StockInfo
import kz.btokmyrza.cryptomarket.domain.repository.StockRepository
import kz.btokmyrza.cryptomarket.util.Constants.CREDIT_CARDS
import kz.btokmyrza.cryptomarket.util.Constants.TRANSACTIONS
import kz.btokmyrza.cryptomarket.util.Resource

class MainTabViewModel(
    private val repository: StockRepository
) : ViewModel() {

    private val _creditCards = MutableLiveData<List<CreditCard>>().apply {
        value = CREDIT_CARDS
    }
    val creditCards: LiveData<List<CreditCard>> = _creditCards

    private val _stockItems = MutableLiveData<List<StockInfo>>()
    val stockItems: LiveData<List<StockInfo>> = _stockItems

    private val _transactions = MutableLiveData<List<Transaction>>().apply {
        value = TRANSACTIONS
    }
    val transactions: LiveData<List<Transaction>> = _transactions

    init {
        getCompanyListings()
    }

    private fun getCompanyListings(
        query: String = "",
        fetchFromRemote: Boolean = false
    ) {
        viewModelScope.launch {
            repository
                .getCompanyListings(fetchFromRemote, query)
                .collect { result ->
                    when(result) {
                        is Resource.Success -> {
                            result.data?.let { listings ->
                                _stockItems.postValue(listings.map { it.toStockInfo() })
                            }
                        }
                        is Resource.Error -> Unit
                        is Resource.Loading -> Unit
                    }
                }
        }
    }

}