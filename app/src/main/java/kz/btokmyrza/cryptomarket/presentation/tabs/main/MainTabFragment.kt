package kz.btokmyrza.cryptomarket.presentation.tabs.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.LinearSmoothScroller
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.databinding.FragmentMainTabBinding
import kz.btokmyrza.cryptomarket.presentation.tabs.main.adapters.CreditCardsAdapter
import kz.btokmyrza.cryptomarket.presentation.tabs.main.adapters.StocksAdapter
import kz.btokmyrza.cryptomarket.presentation.tabs.main.adapters.TransactionsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDate

class MainTabFragment : Fragment() {

    private var _binding: FragmentMainTabBinding? = null
    private val binding get() = _binding!!

    private val mainTabViewModel by viewModel<MainTabViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainTabBinding.inflate(inflater, container, false)

        setCurrentDate()

        setupCreditCardsRecyclerView()
        setupStocksRecyclerView()
        setupTransactionsRecyclerView()

        mainTabViewModel.getTransactions()

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
            stocksAdapter.stockItems = stockItems
        }

        stocksAdapter.setStockInfoClickListener {
            findNavController().navigate(
                R.id.action_mainFragment_to_stockDetailFragment,
                Bundle().apply {
                    putString("stockSymbol", it.stockSymbol)
                    putString("stockName", it.stockName)
                }
            )
        }
    }

    private fun setupTransactionsRecyclerView() {
        val rvTransactions = binding.rvTransactions
        val layoutManager = LinearLayoutManager(requireContext())
        val transactionsAdapter = TransactionsAdapter()
        rvTransactions.adapter = transactionsAdapter
        rvTransactions.layoutManager = layoutManager
        val smoothScroller = object : LinearSmoothScroller(activity) {
            override fun getVerticalSnapPreference(): Int = SNAP_TO_START
        }
        smoothScroller.targetPosition = 0
        layoutManager.startSmoothScroll(smoothScroller)

        mainTabViewModel.transactions.observe(viewLifecycleOwner) { transactions ->
            transactionsAdapter.transactions = transactions
        }
    }

    private fun setCurrentDate() {
        val dayOfWeek = LocalDate.now().dayOfWeek.name
        val day = LocalDate.now().dayOfMonth
        val month = LocalDate.now().month.name
        binding.tvCurrentDate.text = "$dayOfWeek, \n $day $month"
    }

}