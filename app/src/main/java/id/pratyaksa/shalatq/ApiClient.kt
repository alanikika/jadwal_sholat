package id.pratyaksa.shalatq

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    fun create(): ApiInterface {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://muslimsalat.com")
            .build()

        return retrofit.create(ApiInterface::class.java)
    }
}