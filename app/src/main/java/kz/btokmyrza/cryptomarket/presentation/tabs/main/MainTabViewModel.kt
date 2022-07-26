package kz.btokmyrza.cryptomarket.presentation.tabs.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.btokmyrza.cryptomarket.data.mapper.toCreditCard
import kz.btokmyrza.cryptomarket.data.mapper.toStockInfo
import kz.btokmyrza.cryptomarket.data.mapper.toTransaction
import kz.btokmyrza.cryptomarket.domain.model.CreditCard
import kz.btokmyrza.cryptomarket.domain.model.Transaction
import kz.btokmyrza.cryptomarket.domain.model.stocks.StockInfo
import kz.btokmyrza.cryptomarket.domain.repository.CreditCardRepository
import kz.btokmyrza.cryptomarket.domain.repository.StockRepository
import kz.btokmyrza.cryptomarket.domain.repository.TransactionsRepository
import kz.btokmyrza.cryptomarket.util.Constants.CREDIT_CARDS
import kz.btokmyrza.cryptomarket.util.Resource

class MainTabViewModel(
    private val stockRepository: StockRepository,
    private val transactionsRepository: TransactionsRepository,
    private val creditCardRepository: CreditCardRepository
) : ViewModel() {

    private val _creditCards = MutableLiveData<List<CreditCard>>().apply {
        value = CREDIT_CARDS
    }
    val creditCards: LiveData<List<CreditCard>> = _creditCards

    private val _stockItems = MutableLiveData<List<StockInfo>>()
    val stockItems: LiveData<List<StockInfo>> = _stockItems

    private val _transactions = MutableLiveData<List<Transaction>>()
    val transactions: LiveData<List<Transaction>> = _transactions

    private val _totalBalance = MutableLiveData<Float>()
    val totalBalance: LiveData<Float> = _totalBalance

    init {
        getCompanyListings()
    }

    private fun getCompanyListings(
        query: String = "",
        fetchFromRemote: Boolean = false
    ) {
        viewModelScope.launch {
            stockRepository
                .getCompanyListings(fetchFromRemote, query)
                .collect { result ->
                    when (result) {
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

    fun getTransactions() {
        viewModelScope.launch {
            val transactions =
                transactionsRepository.getTransactions().map { it.toTransaction() }.reversed()
            _transactions.postValue(transactions)
        }
    }

    fun getCreditCards() {
        viewModelScope.launch {
            val creditCards = creditCardRepository.getCreditCards().map { it.toCreditCard() }
            if (creditCards.isNotEmpty())
                _creditCards.postValue(creditCards)
        }
    }

    fun getTotalBalance() {
        viewModelScope.launch {
            var totalBalance = 0.0f
            val creditCards = creditCardRepository.getCreditCards()
            creditCards.forEach {
                totalBalance += it.currentBalance
            }
            _totalBalance.postValue(totalBalance)
        }
    }

    fun addCreditCard(
        cardProvider: String,
        bankName: String,
        cardDetails: String,
        currentBalance: Float
    ) {
        viewModelScope.launch {
            creditCardRepository.insertCreditCard(
                cardProvider,
                bankName,
                cardDetails,
                currentBalance
            )
        }
        getCreditCards()
    }

}