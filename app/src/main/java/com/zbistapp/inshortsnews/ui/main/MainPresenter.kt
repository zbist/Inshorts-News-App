package com.zbistapp.inshortsnews.ui.main

import com.zbistapp.inshortsnews.domain.INewsRepo
import com.zbistapp.inshortsnews.domain.NewsEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.schedulers.Schedulers

class MainPresenter(
    private val repository: INewsRepo
) : MainContract.Presenter() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        disposables += repository.getAllNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setNews(it)
            }, {
                viewState.setError(it.localizedMessage)
            })
    }

    override fun onNewsItemClicked(user: NewsEntity) {

    }

    override fun onUpdate() {
        disposables += repository.getAllNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setNews(it)
            }, {
                viewState.setError(it.localizedMessage)
            })
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}