package com.zbistapp.inshortsnews.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.zbistapp.inshortsnews.data.MockNewsRepoImpl
import com.zbistapp.inshortsnews.domain.INewsRepo
import com.zbistapp.inshortsnews.ui.MainActivity
import com.zbistapp.inshortsnews.ui.main.MainFragment
import com.zbistapp.inshortsnews.ui.main.MainPresenter
import dagger.Component
import dagger.Module
import dagger.Provides
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
    fun provideNewsRepo(): INewsRepo = MockNewsRepoImpl()
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