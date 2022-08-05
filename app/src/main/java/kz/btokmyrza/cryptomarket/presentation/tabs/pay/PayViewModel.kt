package kz.btokmyrza.cryptomarket.presentation.tabs.pay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.btokmyrza.cryptomarket.domain.model.Template
import kz.btokmyrza.cryptomarket.domain.repository.TransactionsRepository
import kz.btokmyrza.cryptomarket.util.Constants.TEMPLATES
import kz.btokmyrza.cryptomarket.util.DispatcherProvider

class PayViewModel(
    private val repository: TransactionsRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private val _templates = MutableLiveData<List<Template>>().apply {
        value = TEMPLATES
    }
    val templates: LiveData<List<Template>> = _templates

    fun addTransaction(phoneNumber: String, cardDetails: String, amount: String) {
        viewModelScope.launch(dispatchers.io) {
            repository.insertTransaction(phoneNumber, cardDetails, amount)
        }
    }

}