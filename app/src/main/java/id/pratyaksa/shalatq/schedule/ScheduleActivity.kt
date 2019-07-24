package id.pratyaksa.shalatq.schedule

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ProgressBar
import com.google.gson.Gson
import id.pratyaksa.shalatq.ApiClient
import id.pratyaksa.shalatq.R
import id.pratyaksa.shalatq.model.Prayers
import id.pratyaksa.shalatq.util.invisible
import id.pratyaksa.shalatq.util.visible

class ScheduleActivity : AppCompatActivity(), ScheduleView {

    private var prayers: MutableList<Prayers> = mutableListOf()
    private lateinit var presenter: SchedulePresenter
    private lateinit var adapter: ScheduleAdapter

    private lateinit var rvPrayers: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        rvPrayers = findViewById(R.id.rvPrayersTime)
        progressBar = findViewById(R.id.progressBar)

        val apiClient = ApiClient()
        val gson = Gson()

        presenter = SchedulePresenter(this, apiClient, gson)

        presenter.getScheduleWeeklyByCity()

        adapter = ScheduleAdapter(this, prayers)
        rvPrayers.layoutManager = LinearLayoutManager(this)
        rvPrayers.adapter = adapter

    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.invisible()
    }

    override fun showPrayerTime(data: List<Prayers>) {
        prayers.clear()
        prayers.addAll(data)
        adapter.notifyDataSetChanged()
    }
}
