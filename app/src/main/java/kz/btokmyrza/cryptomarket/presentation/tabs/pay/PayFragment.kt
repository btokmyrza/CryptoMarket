package kz.btokmyrza.cryptomarket.presentation.tabs.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kz.btokmyrza.cryptomarket.databinding.FragmentPayBinding
import kz.btokmyrza.cryptomarket.presentation.tabs.pay.adapters.TemplatesAdapter
import kz.btokmyrza.cryptomarket.util.Constants.AMOUNT
import kz.btokmyrza.cryptomarket.util.Constants.NAME
import kz.btokmyrza.cryptomarket.util.Constants.PHONE_NUMBER
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PayFragment : Fragment() {

    private var _binding: FragmentPayBinding? = null
    private val binding get() = _binding!!

    private val payViewModel by sharedViewModel<PayViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPayBinding.inflate(inflater, container, false)

        setupTemplatesRecyclerView()

        binding.tvTransferToCards.setOnClickListener {
            PayMobileBottomSheet().show(childFragmentManager, null)
        }
        binding.tvTransferToWallet.setOnClickListener {
            PayMobileBottomSheet().show(childFragmentManager, null)
        }

        binding.tvMobile.setOnClickListener {
            PayMobileBottomSheet().show(childFragmentManager, null)
        }

        binding.tvInternet.setOnClickListener {
            PayMobileBottomSheet().show(childFragmentManager, null)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupTemplatesRecyclerView() {
        val rvTemplates = binding.rvTemplates
        val layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.HORIZONTAL, false)
        val templatesAdapter = TemplatesAdapter()
        rvTemplates.adapter = templatesAdapter
        rvTemplates.layoutManager = layoutManager

        templatesAdapter.setTemplateClickListener {
            val payMobileBottomSheet = PayMobileBottomSheet()
            payMobileBottomSheet.arguments = Bundle().apply {
                putString(NAME, it.templateName)
                putString(AMOUNT, it.templateAmount)
            }
            payMobileBottomSheet.show(childFragmentManager, null)
        }

        payViewModel.templates.observe(viewLifecycleOwner) { templates ->
            templatesAdapter.templates = templates
        }
    }

}