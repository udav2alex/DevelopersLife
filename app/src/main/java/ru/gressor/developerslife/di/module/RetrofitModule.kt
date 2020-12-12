package ru.gressor.developerslife.di.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.gressor.developerslife.mvp.model.api.IDataSource
import javax.inject.Named
import javax.inject.Singleton

@Module
class RetrofitModule {

    @Named("baseURL")
    @Provides
    fun getBaseURL() = "https://developerslife.ru"

    @Singleton
    @Provides
    fun getRetrofit(@Named("baseURL") baseURL: String): IDataSource =
            Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(
                            GsonConverterFactory.create(GsonBuilder().create()))
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build()
                    .create(IDataSource::class.java)

}