package id.pratyaksa.shalatq.model

import com.google.gson.annotations.SerializedName

data class Prayers(
    @SerializedName("date_for")
    val date_for: String? = null,

    @SerializedName("fajr")
    val fajr: String? = null,

    @SerializedName("shurooq")
    val shurooq: String? = null,

    @SerializedName("dhuhr")
    val dhuhr: String? = null,

    @SerializedName("asr")
    val asr: String? = null,

    @SerializedName("maghrib")
    val maghrib: String? = null,

    @SerializedName("isha")
    val isha: String? = null)

data class ScheduleResponse(
    @SerializedName("items") val items: List<Prayers>
)
