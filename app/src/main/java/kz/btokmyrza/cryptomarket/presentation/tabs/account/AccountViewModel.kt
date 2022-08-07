package kz.btokmyrza.cryptomarket.presentation.tabs.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.btokmyrza.cryptomarket.data.mapper.toTransaction
import kz.btokmyrza.cryptomarket.domain.model.Transaction
import kz.btokmyrza.cryptomarket.domain.repository.TransactionsRepository

class AccountViewModel(
    private val transactionsRepository: TransactionsRepository,
) : ViewModel() {

    private val _incomeAndExpense = MutableLiveData<List<Float>>()
    val incomeAndExpense: LiveData<List<Float>> = _incomeAndExpense

    fun getIncomeAndExpense() {
        viewModelScope.launch {
            val transactions =
                transactionsRepository.getTransactions().map { it.toTransaction() }
            var income = 0.0f
            var expense = 0.0f
            transactions.let {
                it.forEach {
                    val amount = it.transactionAmount
                    if (amount.contains("-$"))
                        expense -= amount.drop(2).toFloat()
                    else
                        income += amount.drop(2).toFloat()
                }
            }
            _incomeAndExpense.postValue(listOf(income, expense))
        }
    }


}