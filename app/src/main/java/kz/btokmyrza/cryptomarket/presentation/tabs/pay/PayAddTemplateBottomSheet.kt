package kz.btokmyrza.cryptomarket.presentation.tabs.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.databinding.BsdMainTabAddCreditCardBinding
import kz.btokmyrza.cryptomarket.databinding.BsdPayAddTemplateBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PayAddTemplateBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BsdPayAddTemplateBinding? = null
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
        _binding = BsdPayAddTemplateBinding.inflate(inflater, container, false)

        binding.btnAddTemplate.setOnClickListener {
            val templateType = binding.spType.selectedItem.toString()
            val templateName = binding.etTemplateName.text.toString()
            val templateAmount = binding.etTemplateAmount.text.toString()

            if (templateType.isBlank() || templateName.isBlank() || templateAmount.isBlank()) {
                val errorSnackbar = Snackbar.make(
                    binding.root,
                    "Some of the fields are empty!",
                    Snackbar.LENGTH_LONG
                )
                errorSnackbar.anchorView = binding.root
                errorSnackbar.show()
                return@setOnClickListener
            }

            payViewModel.addTemplate(
                templateType,
                templateName,
                templateAmount
            )
            Toast.makeText(requireContext(), "Template added successfully!", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}