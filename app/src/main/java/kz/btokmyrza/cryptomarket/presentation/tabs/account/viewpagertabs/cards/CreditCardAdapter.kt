package kz.btokmyrza.cryptomarket.presentation.tabs.account.viewpagertabs.cards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.databinding.ItemCreditCardBinding
import kz.btokmyrza.cryptomarket.domain.model.CreditCard

class CreditCardAdapter : RecyclerView.Adapter<CreditCardAdapter.CreditCardViewHolder>() {

    private val creditCards = mutableListOf<CreditCard>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditCardViewHolder {
        val binding =
            ItemCreditCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CreditCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CreditCardViewHolder, position: Int) {
        holder.bind(creditCards[position])
    }

    override fun getItemCount(): Int = creditCards.size

    fun setCreditCards(fakeCreditCards: List<CreditCard>) {
        creditCards.clear()
        creditCards.addAll(fakeCreditCards)
        notifyDataSetChanged()
    }

    inner class CreditCardViewHolder(private val binding: ItemCreditCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(creditCard: CreditCard) {
            binding.tvCreditCardName.text = creditCard.bankName
        }

    }
}