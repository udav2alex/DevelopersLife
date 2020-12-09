package ru.gressor.developerslife.di.module

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.gressor.developerslife.mvp.model.api.IDataSource

class RetrofitModule {

    companion object {
        private const val baseURL = "https://developerslife.ru"

        fun getRetrofit(): IDataSource =
                Retrofit.Builder()
                        .baseUrl(baseURL)
                        .addConverterFactory(
                                GsonConverterFactory.create(GsonBuilder().create()))
                        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                        .build()
                        .create(IDataSource::class.java)
    }
}