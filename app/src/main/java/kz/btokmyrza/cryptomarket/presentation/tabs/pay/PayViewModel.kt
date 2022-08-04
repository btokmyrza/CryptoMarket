package kz.btokmyrza.cryptomarket.presentation.tabs.pay

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kz.btokmyrza.cryptomarket.domain.model.Template
import kz.btokmyrza.cryptomarket.util.Constants.TEMPLATES

class PayViewModel : ViewModel() {

    private val _templates = MutableLiveData<List<Template>>().apply {
        value = TEMPLATES
    }
    val templates: LiveData<List<Template>> = _templates

}