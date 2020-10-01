package com.example.coroutinedemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinedemo.R
import com.example.coroutinedemo.data.Quote
import com.example.coroutinedemo.databinding.ItemQuoteBinding

class QuotesAdapter  : RecyclerView.Adapter<QuotesAdapter.QuotesViewModel>()  {
    var quote: List<Quote>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class QuotesViewModel(val binding : ItemQuoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewModel {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_quote,
            parent,
            false
        )
    }

    override fun onBindViewHolder(holder: QuotesViewModel, position: Int) {
        holder.binding.quotes =  quote!![position]
    }

    override fun getItemCount() = quote?.size ?: 0
}