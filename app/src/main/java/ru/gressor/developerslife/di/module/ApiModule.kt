package ru.gressor.developerslife.di.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.gressor.developerslife.mvp.model.api.IDataSource
import ru.gressor.developerslife.mvp.model.network.INetworkStatus
import ru.gressor.developerslife.ui.App
import ru.gressor.developerslife.ui.network.AndroidNetworkStatus
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

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

    @Singleton
    @Provides
    fun getNetworkStatus(app: App): INetworkStatus = AndroidNetworkStatus(app)
}