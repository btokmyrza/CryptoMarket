package kz.btokmyrza.cryptomarket.presentation.tabs.trade.market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.databinding.ItemCryptoCurrencyBinding
import kz.btokmyrza.cryptomarket.domain.model.CryptoCurrency

class CryptoCurrencyAdapter :
    RecyclerView.Adapter<CryptoCurrencyAdapter.CryptoCurrencyViewHolder>() {

    private val cryptoCurrencies = mutableListOf<CryptoCurrency>()
    private var onCryptoClickListener: OnCryptoClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCurrencyViewHolder {
        val binding =
            ItemCryptoCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CryptoCurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoCurrencyViewHolder, position: Int) {
        holder.bind(cryptoCurrencies[position])
    }

    override fun getItemCount(): Int = cryptoCurrencies.size

    fun setCryptoCurrencies(fakeCryptoCurrencies: List<CryptoCurrency>) {
        cryptoCurrencies.clear()
        cryptoCurrencies.addAll(fakeCryptoCurrencies)
        notifyDataSetChanged()
    }

    fun setClickListener(onCryptoClickListener: OnCryptoClickListener) {
        this.onCryptoClickListener = onCryptoClickListener
    }

    inner class CryptoCurrencyViewHolder(private val binding: ItemCryptoCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cryptoCurrency: CryptoCurrency) {
            binding.tvCryptoCurrencyTitle.text = cryptoCurrency.name
            binding.tvCryptoCurrencySubtitle.text = cryptoCurrency.alias
            binding.tvCryptoCurrencyDollar.text = cryptoCurrency.amount
            binding.tvCryptoCurrencyDollarPercent.text = cryptoCurrency.progress
            binding.ivCryptoCurrencyLogo.setImageResource(cryptoCurrency.imgId)

            binding.clParentView.setOnClickListener {
                onCryptoClickListener?.openDetailDialog(cryptoCurrency)
            }
        }

    }
}