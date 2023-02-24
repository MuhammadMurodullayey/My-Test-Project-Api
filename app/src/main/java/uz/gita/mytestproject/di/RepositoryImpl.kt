package uz.gita.mytestproject.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.mytestproject.domein.repository.Repository
import uz.gita.mytestproject.domein.repository.repoimpl.RepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun getRepo(impl: RepositoryImpl): Repository
}