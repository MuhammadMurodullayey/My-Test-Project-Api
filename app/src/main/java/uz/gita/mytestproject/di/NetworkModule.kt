package uz.gita.mytestproject.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.gita.mytestproject.BuildConfig.BASE_URL
import uz.gita.mytestproject.data.remote.api.ProductApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @[Provides Singleton]
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @[Singleton Provides]
    fun getNewsApi(retrofit: Retrofit): ProductApi = retrofit.create(ProductApi::class.java)


}