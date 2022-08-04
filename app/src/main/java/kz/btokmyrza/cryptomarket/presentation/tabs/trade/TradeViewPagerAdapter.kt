package kz.btokmyrza.cryptomarket.presentation.tabs.trade

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import kz.btokmyrza.cryptomarket.presentation.tabs.trade.main.MainTradeFragment
import kz.btokmyrza.cryptomarket.presentation.tabs.trade.market.MarketTradeFragment
import kz.btokmyrza.cryptomarket.presentation.tabs.trade.portfolio.PortfolioTradeFragment

class TradeViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MainTradeFragment()
            1 -> MarketTradeFragment()
            else -> PortfolioTradeFragment()
        }
    }
}