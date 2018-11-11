package ru.yandex.dunaev.mick.myanimation

import android.content.Intent
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){
    val adapter = ItemAdapter()
    var showActivity: (Intent) -> Unit = {}

    init {
        adapter.onItemClick = {onClickItem(it)}
    }

    fun onClickItem(i: Int){
        showActivity(adapter.getItem(i).intent)
    }

    fun setItems(items: List<Item>){
        adapter.setItems(items.toMutableList())
    }
}