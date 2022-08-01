package kz.btokmyrza.cryptomarket.presentation.tabs.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.domain.model.stocks.StockInfo

class StocksAdapter : RecyclerView.Adapter<StocksAdapter.StocksInfoViewHolder>() {

    inner class StocksInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<StockInfo>() {
        override fun areItemsTheSame(oldItem: StockInfo, newItem: StockInfo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: StockInfo, newItem: StockInfo): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    var stockItems: List<StockInfo>
        get() = differ.currentList
        set(value) = differ.submitList(value)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StocksInfoViewHolder {
        return StocksInfoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item_stock_chip,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StocksAdapter.StocksInfoViewHolder, position: Int) {
        val stockItem = stockItems[position]
        holder.itemView.apply {
            val tvStockCompanyName = findViewById<TextView>(R.id.tvStockCompanyName)
            val ivStockDirection = findViewById<ImageView>(R.id.ivStockDirection)
            val tvStockSymbol = findViewById<TextView>(R.id.tvStockSymbol)

            tvStockCompanyName.text = stockItem.stockName
            ivStockDirection.setImageResource(stockItem.stockDirection)
            tvStockSymbol.text = stockItem.stockSymbol

            setOnClickListener {
                onStockInfoClickListener?.let { click ->
                    click(stockItem)
                }
            }
        }
    }

    private var onStockInfoClickListener: ((StockInfo) -> Unit)? = null

    fun setStockInfoClickListener(listener: (StockInfo) -> Unit) {
        onStockInfoClickListener = listener
    }

    override fun getItemCount(): Int {
        return stockItems.size
    }
}