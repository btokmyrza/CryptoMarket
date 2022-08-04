package kz.btokmyrza.cryptomarket.presentation.tabs.trade

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kz.btokmyrza.cryptomarket.databinding.FragmentTradeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TradeFragment : Fragment() {

    private var _binding: FragmentTradeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTradeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPagerTrade.adapter = TradeViewPagerAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayoutTrade, binding.viewPagerTrade) { tab, position ->
            when (position) {
                0 -> tab.text = "Main"
                1 -> tab.text = "Market"
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}