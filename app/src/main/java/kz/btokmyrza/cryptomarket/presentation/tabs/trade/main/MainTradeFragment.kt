package kz.btokmyrza.cryptomarket.presentation.tabs.trade.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.databinding.FragmentMainTradeBinding
import kz.btokmyrza.cryptomarket.domain.model.Currency
import kz.btokmyrza.cryptomarket.domain.model.Watchlist
import kz.btokmyrza.cryptomarket.presentation.tabs.trade.TradeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainTradeFragment : Fragment() {

    private var _binding: FragmentMainTradeBinding? = null
    private val binding get() = _binding!!

    private val tradeViewModel by sharedViewModel<TradeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainTradeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCurrencyRecyclerView()
        setupWatchListRecyclerView()
    }

    private fun setupWatchListRecyclerView() {
        val watchListAdapter = WatchListAdapter()
        binding.rvWatchList.adapter = watchListAdapter
        binding.rvWatchList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        watchListAdapter.setWatchLists(getMockWatchLists())
    }

    private fun setupCurrencyRecyclerView() {
        val currencyAdapter = CurrencyAdapter()
        binding.rvCurrency.adapter = currencyAdapter
        binding.rvCurrency.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        currencyAdapter.setCurrencies(getMockCurrencies())
    }

    private fun getMockCurrencies(): List<Currency> =
        listOf(
            Currency("BTC", "0.0002", R.drawable.img_bitcoin),
            Currency("USD", "7600.00", R.drawable.img_bitcoin),
            Currency("EUR", "421.22", R.drawable.img_bitcoin),
            Currency("BTC", "0.0002", R.drawable.img_bitcoin)
        )

    private fun getMockWatchLists(): List<Watchlist> =
        listOf(
            Watchlist("XRP", "XRP", "$0.27", "-0.5%", R.drawable.img_xrp),
            Watchlist("Bitcoin Cash", "BCH", "$255.85", "-0.13%", R.drawable.img_bitcoin_cash),
            Watchlist("Digibyte", "DGB", "$0.0189", "-1.05%", R.drawable.img_dgb),
            Watchlist("Litecoin", "LTC", "$67.07", "+5.75%", R.drawable.img_ltc),
        )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}