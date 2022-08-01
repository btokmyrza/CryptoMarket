package kz.btokmyrza.cryptomarket.presentation.tabs.main.stock_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kz.btokmyrza.cryptomarket.domain.model.IntradayInfo
import kz.btokmyrza.cryptomarket.domain.repository.StockRepository
import kz.btokmyrza.cryptomarket.util.Resource

class StockDetailViewModel(
    private val repository: StockRepository
) : ViewModel() {

    private val _stockInfos = MutableLiveData<List<IntradayInfo>>()
    val stockInfos: LiveData<List<IntradayInfo>> = _stockInfos

    suspend fun loadStockGraphInfo(symbol: String) {
        viewModelScope.launch {
            val intradayInfoResult = async {
                repository.getIntradayInfo(symbol = symbol)
            }
            when (val result = intradayInfoResult.await()) {
                is Resource.Success -> {
                    _stockInfos.postValue(result.data ?: emptyList())
                }
                is Resource.Error -> Unit
                else -> Unit
            }
        }

    }

}