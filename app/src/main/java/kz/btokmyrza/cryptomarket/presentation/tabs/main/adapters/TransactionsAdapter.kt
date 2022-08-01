package kz.btokmyrza.cryptomarket.presentation.tabs.main.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.domain.model.Transaction

class TransactionsAdapter : RecyclerView.Adapter<TransactionsAdapter.TransactionsViewHolder>() {

    inner class TransactionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<Transaction>() {
        override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    var transactions: List<Transaction>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionsViewHolder {
        return TransactionsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item_main_tab_transaction,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TransactionsViewHolder, position: Int) {
        val transaction = transactions[position]
        holder.itemView.apply {
            val ivTransactionAvatar = findViewById<ImageView>(R.id.ivTransactionAvatar)
            val tvTransactionName = findViewById<TextView>(R.id.tvTransactionName)
            val tvTransactionCardDetails = findViewById<TextView>(R.id.tvTransactionCardDetails)
            val tvTransactionAmount = findViewById<TextView>(R.id.tvTransactionAmount)

            ivTransactionAvatar.setImageResource(transaction.transactionAvatar)
            tvTransactionName.text = transaction.transactionName
            tvTransactionCardDetails.text = transaction.transactionCardDetails
            tvTransactionAmount.text = transaction.transactionAmount
            if (transaction.transactionAmount.contains("+"))
                tvTransactionAmount.setTextColor(getColor(context, R.color.transaction_added))
            else
                tvTransactionAmount.setTextColor(Color.BLACK)
        }
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

}