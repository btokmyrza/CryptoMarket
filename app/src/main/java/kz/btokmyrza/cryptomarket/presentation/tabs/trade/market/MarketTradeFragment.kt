package kz.btokmyrza.cryptomarket.presentation.tabs.trade.market

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.databinding.FragmentMarketTradeBinding
import kz.btokmyrza.cryptomarket.domain.model.CryptoCurrency

class MarketTradeFragment : Fragment() {

    private var _binding: FragmentMarketTradeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarketTradeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCryptoCurrencyRecyclerView()
    }

    private fun setupCryptoCurrencyRecyclerView() {
        val cryptoCurrencyAdapter = CryptoCurrencyAdapter()
        binding.rvCryptoCurrency.adapter = cryptoCurrencyAdapter
        binding.rvCryptoCurrency.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        cryptoCurrencyAdapter.setCryptoCurrencies(getMockCryptoCurrencies())
    }

    private fun getMockCryptoCurrencies(): List<CryptoCurrency> =
        listOf(
            CryptoCurrency("Bitcoin", "BTC", "$16 195.04", "+0.68%", R.drawable.img_currency),
            CryptoCurrency("Ethereum", "ETH", "$451.66", "-1.87%", R.drawable.img_ethereum),
            CryptoCurrency("Tether", "USDT", "$1.00", "+0.02%", R.drawable.img_tether),
            CryptoCurrency("XRP", "XRP", "$0.27", "-0.51%", R.drawable.img_xrp),
            CryptoCurrency("Bitcoin Cash", "BCH", "$255.85", "-0.13%", R.drawable.img_bch),
            CryptoCurrency("Litecoin", "LTC", "$67.07", "+5.75%", R.drawable.img_ltc),
            CryptoCurrency("Cardane", "ADA", "$0.10", "-1.77%", R.drawable.img_cardane),
            CryptoCurrency("Waves", "Waves", "$5.07", "+17.55%", R.drawable.img_waves)
        )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}