package kz.btokmyrza.cryptomarket.presentation.tabs.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.data.mapper.toStr
import kz.btokmyrza.cryptomarket.databinding.BsdPayMobileBinding
import kz.btokmyrza.cryptomarket.util.Constants.AMOUNT
import kz.btokmyrza.cryptomarket.util.Constants.PHONE_NUMBER
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PayMobileBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BsdPayMobileBinding? = null
    private val binding get() = _binding!!

    private val payViewModel by sharedViewModel<PayViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BsdPayMobileBinding.inflate(inflater, container, false)
        setupSelectCardsSpinner()
        payViewModel.getCreditCards()

        val templatePhoneNumber = arguments?.getString(PHONE_NUMBER) ?: "+7"
        val templateAmount = arguments?.getString(AMOUNT) ?: ""

        binding.tilPhoneNumber.editText?.setText(templatePhoneNumber)
        binding.tilAmount.editText?.setText(templateAmount)

        binding.btnCancel.setOnClickListener {
            dismiss()
        }


        binding.btnPay.setOnClickListener {
            val phoneNumber = binding.tilPhoneNumber.editText?.text.toString()
            val cardDetails = binding.tilSelectCard.editText?.text.toString()
            val amount = binding.tilAmount.editText?.text.toString()

            if (phoneNumber.isBlank() || cardDetails.isBlank() || amount.isBlank()) {
                val errorSnackbar = Snackbar.make(
                    binding.root,
                    "Some of the fields are empty!",
                    Snackbar.LENGTH_LONG
                )
                errorSnackbar.anchorView = binding.root
                errorSnackbar.show()
                return@setOnClickListener
            }

            payViewModel.addTransaction(phoneNumber, convertCardDetails(cardDetails), "-$$amount")
            payViewModel.subtractFunds(amount.toFloat(), getBankName(cardDetails))

            PaySuccessBottomSheet().show(parentFragmentManager, null)
            dismiss()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupSelectCardsSpinner() {
        payViewModel.creditCards.observe(viewLifecycleOwner) { creditCards ->
            val creditCardsArr = creditCards.map { it.toStr() }
            val adapter = ArrayAdapter(
                requireContext(),
                R.layout.dropdown_select_card,
                R.id.tvCardInfo,
                creditCardsArr
            )
            binding.atvSelectCard.setAdapter(adapter)
        }
    }

    private fun convertCardDetails(cardDetails: String): String {
        val cardDetailsArr = cardDetails.split("\n")
        val cardProvider = cardDetailsArr[0]
        val lastFourDigits = cardDetailsArr[2].split(" ")[3]
        return "$cardProvider • $lastFourDigits"
    }

    private fun getBankName(cardDetails: String): String {
        return cardDetails.split("\n")[1].split(" (")[0].trim()
    }

}