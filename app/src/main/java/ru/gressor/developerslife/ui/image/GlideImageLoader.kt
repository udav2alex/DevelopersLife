package ru.gressor.developerslife.ui.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import ru.gressor.developerslife.mvp.model.image.IImageLoader

class GlideImageLoader: IImageLoader<ImageView> {
    override fun loadImage(url: String, container: ImageView) {
        Glide.with(container.context)
                .load(url)
                .into(container)
    }
}