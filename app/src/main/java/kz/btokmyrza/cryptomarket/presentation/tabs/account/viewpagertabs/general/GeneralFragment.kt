package kz.btokmyrza.cryptomarket.presentation.tabs.account.viewpagertabs.general

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kz.btokmyrza.cryptomarket.databinding.FragmentGeneralBinding
import kz.btokmyrza.cryptomarket.domain.model.Card
import kz.btokmyrza.cryptomarket.domain.model.TransactionProfile

class GeneralFragment : Fragment() {

    private var _binding: FragmentGeneralBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCardRecyclerView()
        setupTransactionRecyclerView()
    }

    private fun setupCardRecyclerView() {
        val cardAdapter = CardAdapter()
        binding.rvHorizontalCards.adapter = cardAdapter
        binding.rvHorizontalCards.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        cardAdapter.setCards(getMockCards())
    }

    private fun setupTransactionRecyclerView() {
        val transactionAdapter = TransactionProfileAdapter()
        binding.rvVerticalTransaction.adapter = transactionAdapter
        binding.rvVerticalTransaction.layoutManager = LinearLayoutManager(requireContext())

        transactionAdapter.setTransactions(getMockTransactions())
    }

    private fun getMockCards(): List<Card> =
        listOf(
            Card("Nord Bank", "Fast home delivery of the card and free service"),
            Card("Trade", "Invite a friend and you could both get $10 in BTC"),
            Card("Jusan Bank", "Jusan has launched a new project which calls Jusan Junior"),
        )

    private fun getMockTransactions(): List<TransactionProfile> =
        listOf(
            TransactionProfile(
                name = "Anna Enfield",
                detail = "Mastercard ~ 7682",
                amount = "-$700.00"
            ),
            TransactionProfile(
                name = "Coffee Street 3B",
                detail = "Visa ~ 8245",
                amount = "-$12.00"
            ),
            TransactionProfile(name = "COS", detail = "Mastercard ~ 7682", amount = "-$200.00"),
            TransactionProfile(name = "Spotify", detail = "Mastercard ~ 7682", amount = "-$10.00"),
            TransactionProfile(name = "Shopping", detail = "Visa ~ 4528", amount = "-$200.00"),
            TransactionProfile(
                name = "Investing",
                detail = "Mastercard ~ 9465",
                amount = "+$70.00"
            ),
        )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}