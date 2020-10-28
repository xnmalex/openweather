package com.alexgui.openweather.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexgui.openweather.databinding.ItemWeatherBinding
import com.alexgui.openweather.model.data.Weather

class WeatherAdapter(private val listener: WeatherItemListener) : RecyclerView.Adapter<WeatherViewHolder>(){
    interface WeatherItemListener {
        fun onClickedWeather(weatherId: Int)
    }

    private val items = ArrayList<Weather>()

    fun setItems(items: ArrayList<Weather>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding: ItemWeatherBinding = ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) = holder.bind(items[position])

}

class WeatherViewHolder(private val itemBinding: ItemWeatherBinding, private val listener: WeatherAdapter.WeatherItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var weather: Weather

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Weather) {
        this.weather = item
        itemBinding.name.text = ""+item.main.temp
        //itemBinding.speciesAndStatus.text = """${item.species} - ${item.status}"""
//        Glide.with(itemBinding.root)
//            .load(item.image)
//            .transform(CircleCrop())
//            .into(itemBinding.image)
    }

    override fun onClick(v: View?) {
        //listener.onClickedWeather(character.id)
    }
}