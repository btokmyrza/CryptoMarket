package kz.btokmyrza.cryptomarket.presentation.tabs.pay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.btokmyrza.cryptomarket.data.local.credit_card.CreditCardEntity
import kz.btokmyrza.cryptomarket.data.mapper.toCreditCard
import kz.btokmyrza.cryptomarket.domain.model.CreditCard
import kz.btokmyrza.cryptomarket.domain.model.Template
import kz.btokmyrza.cryptomarket.domain.repository.CreditCardRepository
import kz.btokmyrza.cryptomarket.domain.repository.TransactionsRepository
import kz.btokmyrza.cryptomarket.util.Constants
import kz.btokmyrza.cryptomarket.util.Constants.TEMPLATES
import kz.btokmyrza.cryptomarket.util.DispatcherProvider

class PayViewModel(
    private val repository: TransactionsRepository,
    private val creditCardRepository: CreditCardRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private val _templates = MutableLiveData<List<Template>>().apply {
        value = TEMPLATES
    }
    val templates: LiveData<List<Template>> = _templates

    private val _creditCards = MutableLiveData<List<CreditCardEntity>>()
    val creditCards: LiveData<List<CreditCardEntity>> = _creditCards

    fun addTransaction(phoneNumber: String, cardDetails: String, amount: String) {
        viewModelScope.launch(dispatchers.io) {
            repository.insertTransaction(phoneNumber, cardDetails, amount)
        }
    }

    fun getCreditCards() {
        viewModelScope.launch(dispatchers.io) {
            val creditCards = creditCardRepository.getCreditCards()
            if (creditCards.isNotEmpty())
                _creditCards.postValue(creditCards)
        }
    }

    fun subtractFunds(amount: Float, bankName: String) {
        viewModelScope.launch(dispatchers.io) {
            creditCardRepository.changeCreditCardBalance(-amount, bankName)
        }
    }

}