package kz.btokmyrza.cryptomarket.presentation.tabs.main.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.domain.model.stocks.StockAdd
import kz.btokmyrza.cryptomarket.domain.model.stocks.StockInfo
import kz.btokmyrza.cryptomarket.domain.model.stocks.StockItem

class StocksAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class StocksInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    inner class StocksAddViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    var stockItems = mutableListOf<StockItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.rv_item_stock_add -> StocksAddViewHolder(
                inflater.inflate(
                    R.layout.rv_item_stock_add,
                    parent,
                    false
                )
            )
            R.layout.rv_item_stock_chip -> StocksInfoViewHolder(
                inflater.inflate(
                    R.layout.rv_item_stock_chip,
                    parent,
                    false
                )
            )
            else -> StocksInfoViewHolder(
                inflater.inflate(
                    R.layout.rv_item_stock_chip,
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            R.layout.rv_item_stock_add
        } else {
            R.layout.rv_item_stock_chip
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val stockItem = stockItems[position]) {
            is StockInfo -> {
                holder.itemView.apply {
                    val tvStockName = this.findViewById<TextView>(R.id.tvStockName)
                    val ivStockDirection = this.findViewById<ImageView>(R.id.ivStockDirection)
                    val tvStockChangeAmount = this.findViewById<TextView>(R.id.tvStockChangeAmount)

                    tvStockName.text = stockItem.stockName
                    ivStockDirection.setImageResource(stockItem.stockDirection)
                    tvStockChangeAmount.text = stockItem.stockChangeAmount

                    setOnClickListener {
                        onStockInfoClickListener?.let { click ->
                            click(stockItem)
                        }
                    }
                }
            }
            is StockAdd -> {
                holder.itemView.apply {
                    setOnClickListener {
                        onStockAddClickListener?.let { click ->
                            click(stockItem)
                        }
                    }
                }
            }
        }
    }

    private var onStockInfoClickListener: ((StockInfo) -> Unit)? = null

    fun setStockInfoClickListener(listener: (StockInfo) -> Unit) {
        onStockInfoClickListener = listener
    }

    private var onStockAddClickListener: ((StockAdd) -> Unit)? = null

    fun setStockAddClickListener(listener: (StockAdd) -> Unit) {
        onStockAddClickListener = listener
    }

    override fun getItemCount(): Int = stockItems.size

    fun setItems(list: List<StockItem>) {
        stockItems.clear()
        stockItems.addAll(list)
        notifyDataSetChanged()
    }

}