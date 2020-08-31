package com.tomisztomek.kursakademiaandroida.core.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected val items by lazy { mutableListOf<T>() }

    fun setItems(items: List<T>) {
        if (items.isNotEmpty()) {
            this.items.clear()
        }

        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

}