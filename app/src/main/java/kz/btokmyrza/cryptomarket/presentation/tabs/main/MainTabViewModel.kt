package kz.btokmyrza.cryptomarket.presentation.tabs.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.btokmyrza.cryptomarket.domain.model.CreditCard
import kz.btokmyrza.cryptomarket.domain.model.Transaction
import kz.btokmyrza.cryptomarket.domain.model.stocks.StockItem
import kz.btokmyrza.cryptomarket.util.Constants.CREDIT_CARDS
import kz.btokmyrza.cryptomarket.util.Constants.STOCK_ITEMS
import kz.btokmyrza.cryptomarket.util.Constants.TRANSACTIONS

class MainTabViewModel : ViewModel() {

    private val _creditCards = MutableLiveData<List<CreditCard>>().apply {
        value = CREDIT_CARDS
    }
    val creditCards: LiveData<List<CreditCard>> = _creditCards

    private val _stockItems = MutableLiveData<List<StockItem>>().apply {
        value = STOCK_ITEMS
    }
    val stockItems: LiveData<List<StockItem>> = _stockItems

    private val _transactions = MutableLiveData<List<Transaction>>().apply {
        value = TRANSACTIONS
    }
    val transactions: LiveData<List<Transaction>> = _transactions

}