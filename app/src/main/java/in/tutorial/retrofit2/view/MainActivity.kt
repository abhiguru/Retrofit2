package `in`.tutorial.retrofit2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import `in`.tutorial.retrofit2.R
import `in`.tutorial.retrofit2.databinding.ActivityMainBinding
import `in`.tutorial.retrofit2.databinding.ItemBinding
import `in`.tutorial.retrofit2.viewModel.ItemsViewModel

class MainActivity : AppCompatActivity() {
    var binding : ActivityMainBinding? = null
    private val viewModel:ItemsViewModel by viewModels()
    val adapter = ItemsAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        viewModel.refresh()

        binding?.rvItem?.layoutManager = LinearLayoutManager(this)
        binding?.rvItem?.adapter = adapter
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.itemsList.observe(this, Observer {
            items ->
            items?.let {
                binding?.rvItem?.visibility = View.VISIBLE
                adapter.updateItems(it.toMutableList())
            }
        })
    }
}