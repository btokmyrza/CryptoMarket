package kz.btokmyrza.cryptomarket.presentation.tabs.account

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kz.btokmyrza.cryptomarket.databinding.FragmentAccountBinding
import kz.btokmyrza.cryptomarket.util.Constants.CURRENT_USER

class AccountFragment : Fragment() {

    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)

        binding.tvProfileEmail.text = getSavedEmail()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = AccountViewPagerAdapter(childFragmentManager, lifecycle)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "General"
                1 -> tab.text = "Stats"
                2 -> tab.text = "Cards"
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getSavedEmail(): String {
        val prefs = requireContext().getSharedPreferences(
            CURRENT_USER,
            AppCompatActivity.MODE_PRIVATE
        )
        return prefs.getString("email", "ERROR") ?: "ERROR"
    }

}