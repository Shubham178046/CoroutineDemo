package com.example.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coroutinedemo.adapter.QuotesAdapter
import com.example.coroutinedemo.databinding.ActivityMainBinding
import com.example.coroutinedemo.viewModel.QuoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val movieAdapter by lazy{ QuotesAdapter()}
    private lateinit var viewModel : QuoteViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  binding = DataBindingUtil.setContentView(this,R.layout.activity_main )
       rvMovies.layoutManager = LinearLayoutManager(this)
       rvMovies.adapter = movieAdapter
        viewModel =ViewModelProvider(this).get(QuoteViewModel::class.java)
        viewModel.movies.observe(this , Observer {
           movieAdapter.quote = it
        })
    }
}