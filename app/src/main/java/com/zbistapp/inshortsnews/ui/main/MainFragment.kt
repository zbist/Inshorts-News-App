package com.zbistapp.inshortsnews.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zbistapp.inshortsnews.R
import com.zbistapp.inshortsnews.domain.NewsEntity

class MainFragment : Fragment(R.layout.fragment_main), MainContract.View {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setNews(listOfUsers: List<NewsEntity>) {

    }

    override fun setError(errorText: String) {

    }
}