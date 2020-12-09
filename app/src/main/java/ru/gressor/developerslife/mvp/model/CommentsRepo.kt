package ru.gressor.developerslife.mvp.model

interface CommentsRepo {
    fun getComments(pic: PicsRepo)
}