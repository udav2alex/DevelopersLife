package ru.gressor.developerslife.mvp.model.image

interface IImageLoader<T> {
    fun loadImage(url: String, container: T)
}