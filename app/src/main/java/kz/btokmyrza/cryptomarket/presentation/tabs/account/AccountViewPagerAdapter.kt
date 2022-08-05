package kz.btokmyrza.cryptomarket.presentation.tabs.account

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import kz.btokmyrza.cryptomarket.presentation.tabs.account.viewpagertabs.general.GeneralFragment

class AccountViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 1

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> GeneralFragment()
            else -> GeneralFragment()
        }
    }

}