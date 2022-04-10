package com.example.newsappdagger.ui.activities

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.RequestManager
import com.example.newsappdagger.databinding.ActivityMainBinding
import com.example.newsappdagger.repositories.NewsRepository
import com.example.newsappdagger.ui.BaseActivity
import com.example.newsappdagger.ui.adapters.NewsAdapter
import com.example.newsappdagger.ui.viewmodels.NewsViewModel
import com.example.newsappdagger.ui.viewmodels.NewsViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NewsAdapter
//    private lateinit var viewModel: NewsViewModel

    @Inject
    lateinit var glide: RequestManager

    @Inject
    lateinit var viewModelFactory: NewsViewModelFactory

    private lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injector.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this, viewModelFactory).get(NewsViewModel::class.java)

        binding.rvNews.layoutManager = LinearLayoutManager(this@MainActivity)

        lifecycleScope.launch {
            viewModel.getLatestNews()
            viewModel.newsResponseLiveData.observe(this@MainActivity) { newsResponse ->
                adapter = NewsAdapter(newsResponse.articles)

                binding.apply {
                    rvNews.adapter = adapter
                }
            }
        }
//        adapter = NewsAdapter()


    }
}