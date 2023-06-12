package ar.edu.unlam.mobile2.core.data.remote.interceptor

import ar.edu.unlam.mobile2.BuildConfig
import ar.edu.unlam.mobile2.core.data.remote.MovieApi
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder().addQueryParameter(
            "api_key",
            MovieApi.API_KEY
        ).build()
        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)
    }
}
