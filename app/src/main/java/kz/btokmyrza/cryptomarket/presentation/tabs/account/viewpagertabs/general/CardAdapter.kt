package kz.btokmyrza.cryptomarket.presentation.tabs.account.viewpagertabs.general

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.databinding.ItemCardBinding
import kz.btokmyrza.cryptomarket.domain.model.Card

class CardAdapter : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    private val cards = mutableListOf<Card>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(cards[position])
    }

    override fun getItemCount(): Int = cards.size

    fun setCards(fakeCards: List<Card>) {
        cards.clear()
        cards.addAll(fakeCards)
        notifyDataSetChanged()
    }

    inner class CardViewHolder(private val binding: ItemCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(card: Card) {
            Log.i("FragmentGeneral", "bind(${card.name})")
            binding.tvCardName.text = card.name
            binding.tvCardDescription.text = card.description
        }

    }
}