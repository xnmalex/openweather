package com.alexgui.openweather.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexgui.openweather.databinding.FragmentWeatherBinding
import com.alexgui.openweather.utils.Resource
import com.alexgui.openweather.utils.autoCleared
import com.alexgui.openweather.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment(), WeatherAdapter.WeatherItemListener {
    private var binding: FragmentWeatherBinding by autoCleared()
    private val viewModel: WeatherViewModel by viewModels()
    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = WeatherAdapter(this)
        binding.weatherRv.layoutManager = LinearLayoutManager(requireContext())
        binding.weatherRv.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.weatherRv.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.weatherList.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_LONG).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    override fun onClickedWeather(weatherId: Int) {
        TODO("Not yet implemented")
    }

//    override fun onClickedCharacter(characterId: Int) {
//        findNavController().navigate(
//            R.id.action_charactersFragment_to_characterDetailFragment,
//            bundleOf("id" to characterId)
//        )
//    }
}