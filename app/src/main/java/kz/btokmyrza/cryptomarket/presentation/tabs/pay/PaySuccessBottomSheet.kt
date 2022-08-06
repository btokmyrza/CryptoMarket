package kz.btokmyrza.cryptomarket.presentation.tabs.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.databinding.BsdPaySuccessBinding

class PaySuccessBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BsdPaySuccessBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.BottomSheetDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BsdPaySuccessBinding.inflate(inflater, container, false)

        binding.btnDone.setOnClickListener {
            dismiss()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}