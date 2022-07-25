package kz.btokmyrza.cryptomarket.presentation.auth.sign_up

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kz.btokmyrza.cryptomarket.domain.repository.AuthRepository
import kz.btokmyrza.cryptomarket.util.DispatcherProvider

class SignUpViewModel(
    private val repository: AuthRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    val successful: MutableLiveData<Boolean> = MutableLiveData()

    suspend fun signUp(name: String, email: String, password: String) {
        val result = viewModelScope.async(dispatchers.io) {
            repository.signUp(name, email, password)
        }
        successful.postValue(result.await())
    }

}