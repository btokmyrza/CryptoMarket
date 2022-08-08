package kz.btokmyrza.cryptomarket.presentation.tabs.pay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kz.btokmyrza.cryptomarket.databinding.FragmentPayTabBinding
import kz.btokmyrza.cryptomarket.presentation.tabs.pay.adapters.TemplatesAdapter
import kz.btokmyrza.cryptomarket.util.Constants.AMOUNT
import kz.btokmyrza.cryptomarket.util.Constants.NAME
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PayTabFragment : Fragment() {

    private var _binding: FragmentPayTabBinding? = null
    private val binding get() = _binding!!

    private val payViewModel by sharedViewModel<PayViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPayTabBinding.inflate(inflater, container, false)

        setupTemplatesRecyclerView()

        binding.btnAddTemplates.setOnClickListener {
            PayAddTemplateBottomSheet().show(childFragmentManager, null)
        }

        binding.tvTransferToCards.setOnClickListener {
            PayBottomSheet().show(childFragmentManager, null)
        }
        binding.tvTransferToWallet.setOnClickListener {
            PayBottomSheet().show(childFragmentManager, null)
        }

        binding.tvMobile.setOnClickListener {
            PayBottomSheet().show(childFragmentManager, null)
        }

        binding.tvInternet.setOnClickListener {
            PayBottomSheet().show(childFragmentManager, null)
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
            val payBottomSheet = PayBottomSheet()
            payBottomSheet.arguments = Bundle().apply {
                putString(NAME, it.templateName)
                putString(AMOUNT, it.templateAmount)
            }
            payBottomSheet.show(childFragmentManager, null)
        }

        payViewModel.templates.observe(viewLifecycleOwner) { templates ->
            templatesAdapter.templates = templates
        }
    }

}