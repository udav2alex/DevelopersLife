package ru.gressor.developerslife.ui.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.subjects.BehaviorSubject
import ru.gressor.developerslife.mvp.model.network.INetworkStatus

class AndroidNetworkStatus(context: Context) : INetworkStatus {
    private val statusSubject: BehaviorSubject<Boolean> = BehaviorSubject.create()

    init {
        statusSubject.onNext(false)

        val connectivityManager = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val request = NetworkRequest.Builder().build()

        connectivityManager.registerNetworkCallback(
                request,
                object : ConnectivityManager.NetworkCallback() {
                    override fun onAvailable(network: Network) {
                        statusSubject.onNext(true)
                    }

                    override fun onLost(network: Network) {
                        statusSubject.onNext(false)
                    }

                    override fun onUnavailable() {
                        statusSubject.onNext(false)
                    }
                })
    }

    override fun isOnline(): Observable<Boolean> = statusSubject

    override fun isOnlineSingle(): Single<Boolean> = statusSubject.first(false)
}