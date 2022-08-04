package kz.btokmyrza.cryptomarket.presentation.tabs.pay.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.domain.model.Template

class TemplatesAdapter : RecyclerView.Adapter<TemplatesAdapter.TemplatesViewHolder>() {

    inner class TemplatesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val diffCallback = object : DiffUtil.ItemCallback<Template>() {
        override fun areItemsTheSame(oldItem: Template, newItem: Template): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Template, newItem: Template): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    var templates: List<Template>
        get() = differ.currentList
        set(value) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TemplatesViewHolder {
        return TemplatesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.rv_item_pay_template,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TemplatesViewHolder, position: Int) {
        val template = templates[position]
        holder.itemView.apply {
            val ivTemplateLogo = findViewById<ImageView>(R.id.ivTemplateLogo)
            val tvTemplateName = findViewById<TextView>(R.id.tvTemplateName)
            val tvTemplateAmount = findViewById<TextView>(R.id.tvTemplateAmount)

            ivTemplateLogo.setImageResource(template.templateLogo)
            tvTemplateName.text = template.templateName
            tvTemplateAmount.text = template.templateAmount

            setOnClickListener {
                onTemplateClickListener?.let { click ->
                    click(template)
                }
            }
        }
    }

    private var onTemplateClickListener: ((Template) -> Unit)? = null

    fun setTemplateClickListener(listener: (Template) -> Unit) {
        onTemplateClickListener = listener
    }

    override fun getItemCount(): Int = templates.size
}