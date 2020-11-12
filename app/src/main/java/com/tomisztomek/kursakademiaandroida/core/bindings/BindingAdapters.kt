package com.tomisztomek.kursakademiaandroida.core.bindings

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tomisztomek.kursakademiaandroida.core.adapter.BindableAdapter
import com.tomisztomek.kursakademiaandroida.core.base.UiState

object BindingAdapters {

    @BindingAdapter("app:showOnPendingState")
    @JvmStatic
    fun showOnPendingState(progressBar: ProgressBar, UIState: UiState) {
        progressBar.visibility = if (UIState== UiState.Pending) View.VISIBLE else View.GONE
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun <T> setItems(recyclerView: RecyclerView, items: List<T>?) {
        if (items.isNullOrEmpty()) return
        (recyclerView.adapter as? BindableAdapter<T>)?.setItems(items)
    }

    @BindingAdapter(value = ["app:imageURL", "app:placeholder"], requireAll = false)
    @JvmStatic
    fun setImage(imageView: ImageView, imageURL: String, @DrawableRes placeholder: Int) {
        Glide.with(imageView.context)
            .load(imageURL)
            .placeholder(placeholder)
            .into(imageView)
    }
}