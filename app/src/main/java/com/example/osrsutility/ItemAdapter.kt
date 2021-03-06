package com.example.osrsutility

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.osrsutility.databinding.ListItemBinding

class ItemAdapter(val items : List<ItemData>, val listener: (ItemData) -> Unit) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var bigImgUrlBase = "https://secure.runescape.com/m=itemdb_oldschool/obj_big.gif"

    private var _binding: ListItemBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        holder.itemView.setOnClickListener { listener(item) }

        holder.view.findViewById<TextView>(R.id.tvHeading).text = item.name
        holder.view.findViewById<TextView>(R.id.description).text = item.examine

        Glide.with(holder.view.context)
            .load(bigImgUrlBase + "?id=" + item.id)
            .into(holder.view.findViewById(R.id.title_image))

    }

    override fun getItemCount() = items.size


    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}