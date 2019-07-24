package id.pratyaksa.shalatq.schedule

import id.pratyaksa.shalatq.model.Prayers

interface ScheduleView {
    fun showLoading()
    fun hideLoading()
    fun showPrayerTime(data: List<Prayers>)
}