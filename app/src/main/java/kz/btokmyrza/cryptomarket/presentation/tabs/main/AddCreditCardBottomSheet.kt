package kz.btokmyrza.cryptomarket.presentation.tabs.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.databinding.BsdMainTabAddCreditCardBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AddCreditCardBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BsdMainTabAddCreditCardBinding? = null
    private val binding get() = _binding!!

    private val mainTabViewModel by sharedViewModel<MainTabViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BsdMainTabAddCreditCardBinding.inflate(inflater, container, false)

        binding.btnAddCard.setOnClickListener {
            val cardProvider = binding.spCardProvider.selectedItem.toString()
            val bankName = binding.etBankName.text.toString()
            val cardDetails = binding.etCardDetails.text.toString()
            val currentBalance = binding.etCurrentBalance.text.toString()

            if (cardProvider.isBlank() || bankName.isBlank() || cardDetails.isBlank() || currentBalance.isBlank()) {
                val errorSnackbar = Snackbar.make(
                    binding.root,
                    "Some of the fields are empty!",
                    Snackbar.LENGTH_LONG
                )
                errorSnackbar.anchorView = binding.root
                errorSnackbar.show()
                return@setOnClickListener
            }

            mainTabViewModel.addCreditCard(
                cardProvider,
                bankName,
                cardDetails,
                currentBalance.toFloat()
            )
            Toast.makeText(requireContext(), "Card added successfully!", Toast.LENGTH_SHORT).show()
            mainTabViewModel.getCreditCards()
            dismiss()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}