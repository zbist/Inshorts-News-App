package com.zbistapp.inshortsnews.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.zbistapp.inshortsnews.App
import com.zbistapp.inshortsnews.R
import com.zbistapp.inshortsnews.data.MockNewsRepoImpl
import com.zbistapp.inshortsnews.databinding.FragmentMainBinding
import com.zbistapp.inshortsnews.domain.NewsEntity
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainFragment : MvpAppCompatFragment(R.layout.fragment_main), MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val mainPresenter: MainContract.Presenter by moxyPresenter { presenter }

    private lateinit var newsAdapter: NewsAdapter

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.INSTANCE.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        binding.swipeRefreshLayout.setOnRefreshListener {
            mainPresenter.onUpdate()
        }
    }

    private fun initRecyclerView() {
        newsAdapter = NewsAdapter {
            mainPresenter.onNewsItemClicked(it)
        }
        binding.newsRecyclerView.adapter = newsAdapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setNews(listOfNews: List<NewsEntity>) {
        newsAdapter.listOfNews = listOfNews
        newsAdapter.notifyDataSetChanged()
        binding.swipeRefreshLayout.isRefreshing = false
    }

    override fun setError(errorText: String?) {
        Toast.makeText(context, errorText, Toast.LENGTH_SHORT).show()
        binding.swipeRefreshLayout.isRefreshing = false
    }

    override fun onDestroy() {
        binding.newsRecyclerView.adapter = null
        super.onDestroy()
    }
}