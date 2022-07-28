package kz.btokmyrza.cryptomarket.presentation.tabs.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import kz.btokmyrza.cryptomarket.databinding.FragmentMainTabBinding
import kz.btokmyrza.cryptomarket.presentation.tabs.main.adapters.CreditCardsAdapter
import kz.btokmyrza.cryptomarket.presentation.tabs.main.adapters.StocksAdapter
import kz.btokmyrza.cryptomarket.presentation.tabs.main.adapters.TransactionsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainTabFragment : Fragment() {

    private var _binding: FragmentMainTabBinding? = null
    private val binding get() = _binding!!

    private val mainTabViewModel by viewModel<MainTabViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainTabBinding.inflate(inflater, container, false)

        setupCreditCardsRecyclerView()
        setupStocksRecyclerView()
        setupTransactionsRecyclerView()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupCreditCardsRecyclerView() {
        val rvCreditCards = binding.rvCreditCards
        val layoutManager = LinearLayoutManager(requireContext(), HORIZONTAL, false)
        val creditCardsAdapter = CreditCardsAdapter()
        rvCreditCards.adapter = creditCardsAdapter
        rvCreditCards.layoutManager = layoutManager

        mainTabViewModel.creditCards.observe(viewLifecycleOwner) { creditCards ->
            creditCardsAdapter.creditCards = creditCards
        }
    }

    private fun setupStocksRecyclerView() {
        val rvStocks = binding.rvStocks
        val layoutManager = LinearLayoutManager(requireContext(), HORIZONTAL, false)
        val stocksAdapter = StocksAdapter()
        rvStocks.adapter = stocksAdapter
        rvStocks.layoutManager = layoutManager

        mainTabViewModel.stockItems.observe(viewLifecycleOwner) { stockItems ->
            stocksAdapter.setItems(stockItems)
        }
    }

    private fun setupTransactionsRecyclerView() {
        val rvTransactions = binding.rvTransactions
        val layoutManager = LinearLayoutManager(requireContext())
        val transactionsAdapter = TransactionsAdapter()
        rvTransactions.adapter = transactionsAdapter
        rvTransactions.layoutManager = layoutManager

        mainTabViewModel.transactions.observe(viewLifecycleOwner) { transactions ->
            transactionsAdapter.transactions = transactions
        }
    }

}