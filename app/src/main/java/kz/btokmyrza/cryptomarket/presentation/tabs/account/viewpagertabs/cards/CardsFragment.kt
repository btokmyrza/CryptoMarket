package kz.btokmyrza.cryptomarket.presentation.tabs.account.viewpagertabs.cards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.databinding.FragmentCardsBinding
import kz.btokmyrza.cryptomarket.domain.model.CreditCard
import kz.btokmyrza.cryptomarket.domain.model.Transaction

class CardsFragment : Fragment() {

    private var _binding: FragmentCardsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCreditCardsRecyclerView()
        setupTransactionsRecyclerView()
    }

    private fun setupTransactionsRecyclerView() {
        val transactionAdapter = TransactionAdapter()
        binding.rvTransactionList.adapter = transactionAdapter
        binding.rvTransactionList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        transactionAdapter.setTransactions(getMockTransactions())
    }

    private fun setupCreditCardsRecyclerView() {
        val creditCardAdapter = CreditCardAdapter()
        binding.rvCreditCard.adapter = creditCardAdapter
        binding.rvCreditCard.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        creditCardAdapter.setCreditCards(getMockCreditCards())
    }

    private fun getMockTransactions(): List<Transaction> =
        listOf(
            Transaction(
                0,
                R.drawable.img_checkbox,
                "Airline Ticket",
                "MasterCard * 7682",
                "-756.00"
            ),
            Transaction(
                1,
                R.drawable.img_checkbox,
                "Alan Denver",
                "MasterCard * 7682",
                "+280.00"
            ),
            Transaction(
                2,
                R.drawable.img_checkbox,
                "Anna Enfield",
                "MasterCard * 7682",
                "-700.00"
            ),
            Transaction(
                3,
                R.drawable.img_checkbox,
                "COS",
                "MasterCard * 7682",
                "-200.00"
            ),
        )

    private fun getMockCreditCards(): List<CreditCard> {
        return listOf(
            CreditCard(
                0,
                bankName = "Nord Bank",
                cardDetails = "**** 7682",
                moneyAmount = "$5870.00",
                providerLogo = R.drawable.img_master_card
            ),
            CreditCard(
                1,
                bankName = "Sber Bank",
                cardDetails = "**** 4512",
                moneyAmount = "$1433.00",
                providerLogo = R.drawable.img_master_card
            ),
            CreditCard(
                2,
                bankName = "Tinkoff",
                cardDetails = "**** 1234",
                moneyAmount = "$3321.00",
                providerLogo = R.drawable.img_master_card
            )
        )
    }
}