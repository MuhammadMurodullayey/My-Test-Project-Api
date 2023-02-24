package uz.gita.mytestproject.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.gita.mytestproject.R
import uz.gita.mytestproject.data.response.Offer
import uz.gita.mytestproject.databinding.ItemLayoutBinding

class ProductAdapter : ListAdapter<Offer, ProductAdapter.NewsViewHolder>(MyDiffutil)  {
    inner class NewsViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            getItem(absoluteAdapterPosition).apply {
                Glide.with(binding.image)
                    .load(image.url)
                    .placeholder(R.drawable.ic_place_holder)
                    .error(R.drawable.ic_error)
                    .into(binding.image)
                binding.textName.text = name
                binding.textMerchant.text = merchant
                binding.textNameAttributes.text = attributes[1].name
                binding.textValueAttributes.text = attributes[1].value
            }

        }

    }

    private object MyDiffutil : DiffUtil.ItemCallback<Offer>() {
        override fun areItemsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Offer, newItem: Offer): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NewsViewHolder(ItemLayoutBinding.bind(view))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind()
    }
}