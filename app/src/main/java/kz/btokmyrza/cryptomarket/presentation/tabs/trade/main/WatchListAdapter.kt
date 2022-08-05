package kz.btokmyrza.cryptomarket.presentation.tabs.trade.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.databinding.ItemWatchlistBinding
import kz.btokmyrza.cryptomarket.domain.model.CryptoCurrency
import kz.btokmyrza.cryptomarket.domain.model.Watchlist

class WatchListAdapter : RecyclerView.Adapter<WatchListAdapter.WatchListViewHolder>() {

    private val watchLists = mutableListOf<Watchlist>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchListViewHolder {
        val binding =
            ItemWatchlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WatchListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WatchListViewHolder, position: Int) {
        holder.bind(watchLists[position])
    }

    override fun getItemCount(): Int = watchLists.size

    fun add(watchlist: Watchlist) {
        watchLists.add(0, watchlist)
        notifyDataSetChanged()
    }

    inner class WatchListViewHolder(private val binding: ItemWatchlistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(watchlist: Watchlist) {
            binding.tvWatchListTitle.text = watchlist.title
            binding.tvWatchListSubtitle.text = watchlist.subtitle
            binding.tvWatchListDollar.text = watchlist.amount
            binding.tvWatchListDollarPercent.text = watchlist.progress
            binding.ivWatchListLogo.setImageResource(watchlist.imgId)
        }

    }
}