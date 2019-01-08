package com.mike.jsontest
import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkAPI {

    @GET("posts/")
    fun getAllPosts(): Observable<Items>
}
