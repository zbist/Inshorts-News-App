package com.zbistapp.inshortsnews

import android.app.appsearch.SearchResult
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.nhaarman.mockito_kotlin.any
import com.zbistapp.inshortsnews.domain.INewsRepo
import com.zbistapp.inshortsnews.domain.NewsEntity
import com.zbistapp.inshortsnews.domain.RetrofitDataResponse
import com.zbistapp.inshortsnews.ui.main.MainPresenter
import com.zbistapp.inshortsnews.utils.Screens
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

class MainPresenterTest {

    private lateinit var presenter: MainPresenter

    @Mock
    private lateinit var repository: INewsRepo

    @Mock
    private lateinit var cicerone: Cicerone<Router>

    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter(cicerone.router, repository)
    }

    @Test
    fun onNewsItemClicked_Test() {

        val screen = Screens.newsDetailsScreen(any())
        Mockito.verify(cicerone.router, Mockito.times(1)).navigateTo(screen)
    }

    @Test
    fun onUpdate_Test() {

        val response = Mockito.mock(Response::class.java) as Response<RetrofitDataResponse?>

        val searchResults =
            listOf(NewsEntity("", "", "", "", "", "", ""))

        Mockito.`when`(response.body()).thenReturn(RetrofitDataResponse(searchResults))

        val screen = Screens.newsDetailsScreen(any())
        Mockito.verify(cicerone.router, Mockito.times(1)).navigateTo(screen)
    }

}