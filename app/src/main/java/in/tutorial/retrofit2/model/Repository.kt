package `in`.tutorial.retrofit2.model

import `in`.tutorial.retrofit2.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.UUID

object Repository {
    private val BASE_URL = "https://www.gurucold.in:2828/"
    val okHttpClient = OkHttpClient.Builder()
    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        if(BuildConfig.DEBUG){
            okHttpClient.addInterceptor(logging)
        }
    }
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient.build())
        .build()
        .create(Api::class.java)
    fun item(id:UUID) = api.getItem(resourceId = id)
    fun itemsList() = api.getItemsList()
}