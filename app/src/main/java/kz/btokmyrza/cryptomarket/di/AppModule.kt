package kz.btokmyrza.cryptomarket.di

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kz.btokmyrza.cryptomarket.data.repository.AuthRepositoryImpl
import kz.btokmyrza.cryptomarket.domain.repository.AuthRepository
import kz.btokmyrza.cryptomarket.presentation.auth.login.LoginViewModel
import kz.btokmyrza.cryptomarket.presentation.auth.sign_up.SignUpViewModel
import kz.btokmyrza.cryptomarket.presentation.tabs.main.MainTabViewModel
import kz.btokmyrza.cryptomarket.presentation.tabs.main.stock_detail.StockDetailViewModel
import kz.btokmyrza.cryptomarket.util.DispatcherProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<DispatcherProvider> {
        object : DispatcherProvider {
            override val main: CoroutineDispatcher
                get() = Dispatchers.Main
            override val io: CoroutineDispatcher
                get() = Dispatchers.IO
            override val default: CoroutineDispatcher
                get() = Dispatchers.Default
            override val unconfined: CoroutineDispatcher
                get() = Dispatchers.Unconfined
        }
    }

    viewModel {
        SignUpViewModel(repository = get(), dispatchers = get())
    }

    viewModel {
        LoginViewModel(repository = get(), dispatchers = get())
    }

    viewModel {
        MainTabViewModel(repository = get())
    }

    viewModel {
        StockDetailViewModel(repository = get())
    }

}