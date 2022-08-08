package kz.btokmyrza.cryptomarket.presentation.tabs.pay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.data.local.credit_card.CreditCardEntity
import kz.btokmyrza.cryptomarket.domain.model.Template
import kz.btokmyrza.cryptomarket.domain.repository.CreditCardRepository
import kz.btokmyrza.cryptomarket.domain.repository.TransactionsRepository
import kz.btokmyrza.cryptomarket.util.Constants.TEMPLATES
import kz.btokmyrza.cryptomarket.util.DispatcherProvider
import kotlin.random.Random

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

    fun addTemplate(
        templateType: String,
        templateName: String,
        templateAmount: String
    ) {
        val template = Template(
            id = Random.nextInt(),
            templateLogo = when (templateType) {
                "Person" -> R.drawable.template_john
                "Phone" -> R.drawable.template_phone
                "Internet" -> R.drawable.template_internet
                "House Rent" -> R.drawable.template_house_rent
                else -> R.drawable.ic_money_transfer
            },
            templateName = templateName,
            templateAmount = templateAmount
        )
        val newList = _templates.value?.plus(listOf(template))
        _templates.postValue(newList)
    }

}