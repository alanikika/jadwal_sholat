package id.pratyaksa.shalatq.schedule

import android.util.Log
import com.google.gson.Gson
import id.pratyaksa.shalatq.ApiClient
import id.pratyaksa.shalatq.model.Prayers
import id.pratyaksa.shalatq.model.ScheduleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchedulePresenter(private val view: ScheduleView,
                        private val apiClient: ApiClient,
                        private val gson: Gson) {

    fun getScheduleWeeklyByCity(){
        view.showLoading()

        val getData = apiClient.create()
        getData.getScheduleWeeklyByCity().enqueue(object : Callback<ScheduleResponse>{
            override fun onResponse(call: Call<ScheduleResponse>, response: Response<ScheduleResponse>) {
                view.hideLoading()
                if(response.isSuccessful) {
                    val data = response.body()
                    Log.d("Value ", data.toString())
                    val value = gson.toJson(data)
                    Log.d("Value ", value)
                    val dataNew = gson.fromJson(value, ScheduleResponse::class.java)
                    Log.d("Value ", dataNew.items.toString())

                    view.hideLoading()
                    view.showPrayerTime(dataNew.items)
                } else{
                    Log.e("Response", "Gagal")
                }
            }

            override fun onFailure(call: Call<ScheduleResponse>, t: Throwable) {
                Log.e("Error", "${t.message}")
            }

        })

    }

}
