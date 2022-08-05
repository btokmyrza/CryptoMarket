package kz.btokmyrza.cryptomarket.presentation.tabs.trade.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kz.btokmyrza.cryptomarket.data.mapper.toCryptoCurrency
import kz.btokmyrza.cryptomarket.databinding.FragmentMarketTradeBinding
import kz.btokmyrza.cryptomarket.domain.model.CryptoCurrency
import kz.btokmyrza.cryptomarket.presentation.tabs.trade.TradeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MarketTradeFragment : Fragment() {

    private var _binding: FragmentMarketTradeBinding? = null
    private val binding get() = _binding!!

    private val tradeViewModel by sharedViewModel<TradeViewModel>()

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
        binding.rvCryptoCurrency.layoutManager = LinearLayoutManager(requireContext())

        cryptoCurrencyAdapter.setClickListener(object : OnCryptoClickListener {
            override fun openDetailDialog(cryptoCurrency: CryptoCurrency) {
                AddCryptoBottomSheet.newInstance(cryptoCurrency).show(childFragmentManager, null)
            }
        })

        tradeViewModel.coins.observe(viewLifecycleOwner) { coins ->
            cryptoCurrencyAdapter.setCryptoCurrencies(coins.map { it.toCryptoCurrency() })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    /*    private fun getMockCryptoCurrencies(): List<CryptoCurrency> = listOf(
        CryptoCurrency("Bitcoin", "BTC", "$16 195.04", "+0.68%", R.drawable.img_bitcoin),
        CryptoCurrency("Ethereum", "ETH", "$451.66", "-1.87%", R.drawable.img_ethereum),
        CryptoCurrency("Tether", "USDT", "$1.00", "+0.02%", R.drawable.img_tether),
        CryptoCurrency("XRP", "XRP", "$0.27", "-0.51%", R.drawable.img_xrp),
        CryptoCurrency("Bitcoin Cash", "BCH", "$255.85", "-0.13%", R.drawable.img_bitcoin_cash),
        CryptoCurrency("Litecoin", "LTC", "$67.07", "+5.75%", R.drawable.img_ltc),
        CryptoCurrency("Cardane", "ADA", "$0.10", "-1.77%", R.drawable.img_cardane),
        CryptoCurrency("Waves", "Waves", "$5.07", "+17.55%", R.drawable.img_waves)
    )*/
}