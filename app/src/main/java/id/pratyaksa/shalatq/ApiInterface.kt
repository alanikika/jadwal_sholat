package id.pratyaksa.shalatq

import id.pratyaksa.shalatq.model.ScheduleResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/jakarta.json?key=d16ffb40d5e33171bebe7633fc6594e3")
    fun getScheduleByCity(): Call<ScheduleResponse>

    @GET("jakarta/weekly.json?key=d16ffb40d5e33171bebe7633fc6594e3")
    fun getScheduleWeeklyByCity() : Call<ScheduleResponse>
}