package com.zbistapp.inshortsnews.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.zbistapp.inshortsnews.BuildConfig
import com.zbistapp.inshortsnews.data.NewsRepoImpl
import com.zbistapp.inshortsnews.domain.INewsRepo
import com.zbistapp.inshortsnews.domain.network.NewsApi
import com.zbistapp.inshortsnews.ui.MainActivity
import com.zbistapp.inshortsnews.ui.main.MainFragment
import com.zbistapp.inshortsnews.ui.main.MainPresenter
import dagger.Component
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class CiceroneModule {
    @Provides
    @Singleton
    fun provideCicerone() = Cicerone.create()

    @Provides
    @Singleton
    fun provideCiceroneRouter(cicerone: Cicerone<Router>) = cicerone.router

    @Provides
    @Singleton
    fun provideCiceroneNavigatorHolder(cicerone: Cicerone<Router>) = cicerone.getNavigatorHolder()
}

@Module
class ReposModule {
    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideCallAdapterFactory(): CallAdapter.Factory =
        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())

    @Provides
    @Singleton
    fun provideRetrofit(
        converterFactory: Converter.Factory,
        callAdapterFactory: CallAdapter.Factory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addCallAdapterFactory(callAdapterFactory)
        .addConverterFactory(converterFactory)
        .build()

    @Provides
    @Singleton
    fun provideGithubApi(retrofit: Retrofit): NewsApi = retrofit.create(NewsApi::class.java)

    @Provides
    @Singleton
    fun provideGithubRepo(githubApi: NewsApi): INewsRepo = NewsRepoImpl(githubApi)
}

@Module
class PresentersModule {
    @Provides
    fun provideMainPresenter(router: Router, repo: INewsRepo) = MainPresenter(router, repo)
}

@Component(modules = [PresentersModule::class, ReposModule::class, CiceroneModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)
}