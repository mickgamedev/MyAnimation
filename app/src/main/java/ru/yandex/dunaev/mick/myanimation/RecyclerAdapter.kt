package ru.yandex.dunaev.mick.myanimation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import ru.yandex.dunaev.mick.myanimation.databinding.CardItemBinding
import java.util.*

class ItemAdapter : CategoryAdapter<Item, CardItemBinding>(R.layout.card_item) {

    var onStartDrag:(RecyclerView.ViewHolder) -> Unit = {}

    override fun onBindViewHolder(holder: CategoryHolder<CardItemBinding>, position: Int) = with(holder.binding){
        holder.itemView.setOnClickListener { onItemClick(position) }
        data = getItem(position)
        executePendingBindings()
    }
}

abstract class  CategoryAdapter<T: Any,V: ViewDataBinding>(val layout: Int) : RecyclerView.Adapter<CategoryAdapter.CategoryHolder<V>>(){
    private var items = mutableListOf<T>()
    var onItemClick: (Int) -> Unit = {v -> Log.v("NOT BINDING","v = $v")}

    fun setItems(list: MutableList<T>){
        items = list
        notifyDataSetChanged()
        Log.w("ADAPTER","setItems list size = ${list.size}")
    }
    fun getItem(position: Int) = items[position]
    fun getItems() = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder<V> {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<V>(inflater, layout, parent,false)
        return CategoryHolder<V>(binding)
    }

    override fun getItemCount()= items.size

    fun onSwipe(i: Int){
        items.removeAt(i)
        notifyItemRemoved(i);
    }

    fun onMove(fromPosition: Int, toPosition: Int){
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(items, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(items, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    class CategoryHolder<V: ViewDataBinding>(val binding: V): RecyclerView.ViewHolder(binding.root)
}
