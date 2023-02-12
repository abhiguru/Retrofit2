package `in`.tutorial.retrofit2.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import `in`.tutorial.retrofit2.databinding.ItemBinding
import `in`.tutorial.retrofit2.model.Result

class ItemsAdapter(
    private val itemsList: MutableList<Result>
): RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {
    class ViewHolder(val binding : ItemBinding) : RecyclerView.ViewHolder(binding.root){
        val itemName = binding.tvItemName
        val description = binding.tvDescription
        val packaging = binding.tvPackaging
        val active = binding.swActive
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = itemsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = itemsList[position]
        holder.itemName.text = model.name
        holder.description.text = model.description
        holder.packaging.text = model.packaging
        holder.active.isChecked = model.active
    }

    fun updateItems(update:MutableList<Result>){
        itemsList.clear()
        itemsList.addAll(update)
        notifyDataSetChanged()
    }
}