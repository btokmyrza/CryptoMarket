package kz.btokmyrza.cryptomarket.presentation.tabs.trade.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.data.mapper.map
import kz.btokmyrza.cryptomarket.databinding.FragmentMainTradeBinding
import kz.btokmyrza.cryptomarket.domain.model.Currency
import kz.btokmyrza.cryptomarket.domain.model.Watchlist
import kz.btokmyrza.cryptomarket.presentation.tabs.trade.TradeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class MainTradeFragment : Fragment() {

    private var _binding: FragmentMainTradeBinding? = null
    private val binding get() = _binding!!

    private val tradeViewModel by sharedViewModel<TradeViewModel>()

    private val watchListAdapter = WatchListAdapter()
    private val currencyAdapter = CurrencyAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainTradeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tradeViewModel.currency.observe(viewLifecycleOwner) {
            watchListAdapter.add(it.map())
        }

        setupCurrencyRecyclerView()
        setupWatchListRecyclerView()
    }

    private fun setupWatchListRecyclerView() {
        binding.rvWatchList.adapter = watchListAdapter
        binding.rvWatchList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    private fun setupCurrencyRecyclerView() {
        binding.rvCurrency.adapter = currencyAdapter
        binding.rvCurrency.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        currencyAdapter.setCurrencies(getMockWalletCurrencies())
    }

    private fun getMockWalletCurrencies(): List<Currency> =
        listOf(
            Currency("BTC", "0.0002", R.drawable.img_bitcoin),
            Currency("USD", "7600.00", R.drawable.img_bitcoin),
            Currency("EUR", "421.22", R.drawable.img_bitcoin),
            Currency("BTC", "0.0002", R.drawable.img_bitcoin)
        )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}