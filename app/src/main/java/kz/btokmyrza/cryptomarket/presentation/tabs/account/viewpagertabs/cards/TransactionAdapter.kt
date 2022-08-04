package kz.btokmyrza.cryptomarket.presentation.tabs.account.viewpagertabs.cards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.databinding.ItemCardTransactionBinding
import kz.btokmyrza.cryptomarket.domain.model.Transaction

class TransactionAdapter : RecyclerView.Adapter<TransactionAdapter.ViewHolderTransactions>() {

    private val transactions = mutableListOf<Transaction>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTransactions {
        val binding =
            ItemCardTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderTransactions(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderTransactions, position: Int) {
        holder.bind(transactions[position])
    }

    override fun getItemCount(): Int = transactions.size

    fun setTransactions(fakeTransactions: List<Transaction>) {
        transactions.clear()
        transactions.addAll(fakeTransactions)
        notifyDataSetChanged()
    }

    inner class ViewHolderTransactions(private val binding: ItemCardTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(transaction: Transaction) {
            binding.tvCardTransactionName.text = transaction.transactionName
            binding.tvCardTransactionDetail.text = transaction.transactionCardDetails
            binding.tvCardDollarAmount.text = transaction.transactionAmount
            binding.ivTransactionCheckBox.setImageResource(transaction.transactionAvatar)
        }

    }
}