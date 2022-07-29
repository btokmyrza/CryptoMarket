package kz.btokmyrza.cryptomarket.presentation.tabs.account.viewpagertabs.general

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.databinding.ItemTransactionBinding
import kz.btokmyrza.cryptomarket.domain.model.TransactionProfile

class TransactionProfileAdapter : RecyclerView.Adapter<TransactionProfileAdapter.TransactionViewHolder>() {

    private val transactions = mutableListOf<TransactionProfile>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding =
            ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(transactions[position])
    }

    override fun getItemCount(): Int = transactions.size

    fun setTransactions(fakeTransactions: List<TransactionProfile>) {
        transactions.clear()
        transactions.addAll(fakeTransactions)
        notifyDataSetChanged()
    }

    inner class TransactionViewHolder(val binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(transaction: TransactionProfile) {
            binding.tvTransactionName.text = transaction.name
            binding.tvTransactionDetail.text = transaction.detail
            binding.tvDollarAmount.text = transaction.amount
        }

    }
}