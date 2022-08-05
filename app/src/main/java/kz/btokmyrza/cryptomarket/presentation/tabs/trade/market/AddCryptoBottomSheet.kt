package kz.btokmyrza.cryptomarket.presentation.tabs.trade.market

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kz.btokmyrza.cryptomarket.databinding.BsdCryptoDetailBinding
import kz.btokmyrza.cryptomarket.domain.model.CryptoCurrency
import kz.btokmyrza.cryptomarket.presentation.tabs.trade.TradeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

private const val CRYPTO_CURRENCY = "crypto_currency"

class AddCryptoBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BsdCryptoDetailBinding? = null
    private val binding get() = _binding!!

    private val tradeViewModel by sharedViewModel<TradeViewModel>()

    companion object {
        fun newInstance(cryptoCurrency: CryptoCurrency): AddCryptoBottomSheet {
            val fragment = AddCryptoBottomSheet()
            val bundle = Bundle()
            bundle.putSerializable(CRYPTO_CURRENCY, cryptoCurrency)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BsdCryptoDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cryptoCurrency: CryptoCurrency =
            arguments?.getSerializable(CRYPTO_CURRENCY) as CryptoCurrency

        binding.btnAddToWatchList.setOnClickListener {
            tradeViewModel.addToWatchList(cryptoCurrency)
            Toast.makeText(requireContext(), "Crypto added successfully", Toast.LENGTH_SHORT).show()
            dismiss()
        }
    }
}