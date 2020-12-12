package ru.gressor.developerslife.di.module

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import ru.gressor.developerslife.mvp.model.image.IImageLoader
import ru.gressor.developerslife.ui.image.GlideImageLoader
import javax.inject.Singleton

@Module
class ImageModule {

    @Singleton
    @Provides
    fun getImageLoader(): IImageLoader<ImageView> = GlideImageLoader()
}