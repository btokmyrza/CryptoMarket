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

class MainTradeFragment : Fragment() {

    private var _binding: FragmentMainTradeBinding? = null
    private val binding get() = _binding!!

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
            Currency("BTC", "0.0002", R.drawable.img_currency),
            Currency("USD", "7600.00", R.drawable.img_currency),
            Currency("EUR", "421.22", R.drawable.img_currency),
            Currency("BTC", "0.0002", R.drawable.img_currency)
        )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}