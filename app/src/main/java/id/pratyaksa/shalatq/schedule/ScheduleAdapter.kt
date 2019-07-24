package id.pratyaksa.shalatq.schedule

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import id.pratyaksa.shalatq.R
import id.pratyaksa.shalatq.model.Prayers

class ScheduleAdapter (private val context: Context, private val prayers: List<Prayers>)
    : RecyclerView.Adapter<PrayersViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PrayersViewHolder(LayoutInflater.from(context).inflate(R.layout.item_prayers, parent, false))

    override fun getItemCount(): Int = prayers.size

    override fun onBindViewHolder(holder: PrayersViewHolder, position: Int) {
        holder.bindItem(prayers[position])
    }
}

class PrayersViewHolder(view: View) : RecyclerView.ViewHolder(view){
    private val date = view.findViewById<TextView>(R.id.tvDate)
    private val subuh = view.findViewById<TextView>(R.id.tvSubuh)
    private val shuruq = view.findViewById<TextView>(R.id.tvShuruq)
    private val dzuhur = view.findViewById<TextView>(R.id.tvDzuhur)
    private val ashar = view.findViewById<TextView>(R.id.tvAshar)
    private val maghrib = view.findViewById<TextView>(R.id.tvMaghrib)
    private val isya = view.findViewById<TextView>(R.id.tvIsya)

    fun bindItem(prayers: Prayers){
        date.text = prayers.date_for
        subuh.text = prayers.fajr
        shuruq.text = prayers.shurooq
        dzuhur.text = prayers.dhuhr
        ashar.text = prayers.asr
        maghrib.text = prayers.maghrib
        isya.text = prayers.isha
    }
}