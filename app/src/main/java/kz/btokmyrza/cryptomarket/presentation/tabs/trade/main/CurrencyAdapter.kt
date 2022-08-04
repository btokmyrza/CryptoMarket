package kz.btokmyrza.cryptomarket.presentation.tabs.trade.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.databinding.ItemCurrencyBinding
import kz.btokmyrza.cryptomarket.domain.model.Currency

class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.CurrencyViewHolder>() {

    private val currencies = mutableListOf<Currency>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val binding =
            ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.bind(currencies[position])
    }

    override fun getItemCount(): Int = currencies.size

    fun setCurrencies(fakeCurrencies: List<Currency>) {
        currencies.clear()
        currencies.addAll(fakeCurrencies)
        notifyDataSetChanged()
    }

    inner class CurrencyViewHolder(private val binding: ItemCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(currency: Currency) {
            binding.tvCurrencyTitle.text = currency.name
            binding.tvCurrencySubtitle.text = currency.amount
            binding.ivCurrency.setImageResource(currency.imgId)
        }

    }
}