package kz.btokmyrza.cryptomarket.presentation.tabs.trade.market

import kz.btokmyrza.cryptomarket.domain.model.CryptoCurrency

interface OnCryptoClickListener {

    fun openDetailDialog(cryptoCurrency: CryptoCurrency)

}