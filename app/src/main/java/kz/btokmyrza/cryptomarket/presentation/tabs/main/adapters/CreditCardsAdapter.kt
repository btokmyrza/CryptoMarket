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
import kz.btokmyrza.cryptomarket.domain.model.CreditCard

class CreditCardsAdapter : RecyclerView.Adapter<CreditCardsAdapter.CreditCardsViewHolder>() {

    inner class CreditCardsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<CreditCard>() {
        override fun areItemsTheSame(oldItem: CreditCard, newItem: CreditCard): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CreditCard, newItem: CreditCard): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    var creditCards: List<CreditCard>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditCardsViewHolder {
        return CreditCardsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item_main_tab_credit_card,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CreditCardsViewHolder, position: Int) {
        val creditCard = creditCards[position]
        holder.itemView.apply {
            val ivCardProviderLogo = findViewById<ImageView>(R.id.ivCardProviderLogo)
            val tvBankName = findViewById<TextView>(R.id.tvBankName)
            val tvCardDetails = findViewById<TextView>(R.id.tvCardDetails)
            val tvMoneyAmount = findViewById<TextView>(R.id.tvMoneyAmount)

            ivCardProviderLogo.setImageResource(creditCard.providerLogo)
            tvBankName.text = creditCard.bankName
            tvCardDetails.text = creditCard.cardDetails
            tvMoneyAmount.text = "$" + creditCard.moneyAmount

            setOnClickListener {
                onCreditCardClickListener?.let { click ->
                    click(creditCard)
                }
            }
        }
    }

    private var onCreditCardClickListener: ((CreditCard) -> Unit)? = null

    fun setCreditCardClickListener(listener: (CreditCard) -> Unit) {
        onCreditCardClickListener = listener
    }

    override fun getItemCount(): Int {
        return creditCards.size
    }

}