package kz.btokmyrza.cryptomarket.presentation.tabs.account.viewpagertabs.general

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.databinding.ItemStatBinding
import kz.btokmyrza.cryptomarket.domain.model.Statistics

class StatsAdapter : RecyclerView.Adapter<StatsAdapter.StatsViewHolder>() {

    private val statistics = mutableListOf<Statistics>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatsViewHolder {
        val binding = ItemStatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StatsViewHolder, position: Int) {
        holder.bind(statistics[position], position)
    }

    override fun getItemCount(): Int = statistics.size

    fun setStats(fakeStats: List<Statistics>) {
        statistics.clear()
        statistics.addAll(fakeStats)
        notifyDataSetChanged()
    }

    inner class StatsViewHolder(private val binding: ItemStatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(statistics: Statistics, position: Int) {
            if (position == 0) {
                binding.tvStatisticsDollarAmount.setTextColor(Color.parseColor("#68B259"))
            }
            binding.tvStatisticsName.text = statistics.name
            binding.tvStatisticsDollarAmount.text = statistics.amount
        }

    }
}