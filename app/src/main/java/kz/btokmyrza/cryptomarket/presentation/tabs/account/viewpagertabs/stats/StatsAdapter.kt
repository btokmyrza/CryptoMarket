package kz.btokmyrza.cryptomarket.presentation.tabs.account.viewpagertabs.stats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.databinding.ItemStatBinding

class StatsAdapter : RecyclerView.Adapter<StatsAdapter.StatsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        val binding = ItemStatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    fun setStats(){

    }

    inner class StatsViewHolder(private val binding: ItemStatBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }
}