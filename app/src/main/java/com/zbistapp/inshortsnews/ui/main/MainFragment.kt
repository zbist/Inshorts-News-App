package com.zbistapp.inshortsnews.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Toast
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zbistapp.inshortsnews.R
import com.zbistapp.inshortsnews.data.MockNewsRepoImpl
import com.zbistapp.inshortsnews.databinding.FragmentMainBinding
import com.zbistapp.inshortsnews.domain.NewsEntity
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class MainFragment : MvpAppCompatFragment(R.layout.fragment_main), MainContract.View {

    private val binding: FragmentMainBinding by viewBinding(FragmentMainBinding::bind)
    private val mainPresenter: MainContract.Presenter by moxyPresenter {
        MainPresenter(MockNewsRepoImpl())
    }

    private lateinit var newsAdapter: NewsAdapter

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
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
    override fun setNews(listOfUsers: List<NewsEntity>) {
        newsAdapter.listOfNews = listOfUsers
        newsAdapter.notifyDataSetChanged()
        binding.swipeRefreshLayout.isRefreshing = false
    }

    override fun setError(errorText: String?) {
        Toast.makeText(context, errorText, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.newsRecyclerView.adapter = null
    }
}