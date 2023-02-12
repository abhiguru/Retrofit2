package `in`.tutorial.retrofit2.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import `in`.tutorial.retrofit2.model.ItemsList
import `in`.tutorial.retrofit2.model.Repository
import `in`.tutorial.retrofit2.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemsViewModel:ViewModel() {
    val itemsList = MutableLiveData<List<Result>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<Boolean>()

    fun refresh(){
        Repository.itemsList().enqueue(object : Callback<ItemsList>{
            override fun onResponse(call: Call<ItemsList>, response: Response<ItemsList>) {
              var body = response.body()
              body?.results?.let {
                  if(body.results.isNotEmpty()) {
                      Log.e("Details List ", body.results[0].name + " " + body.results[0].packaging)
                      itemsList.value = it
                      loading.value = false
                      error.value = false
                  }
              }
            }
            override fun onFailure(call: Call<ItemsList>, t: Throwable) {
                t.localizedMessage?.let { Log.e("Call Failure", it) }
                loading.value = false
                error.value = true
            }
        })
    }

    private fun onError(message: String) {
        error.value = true
        loading.value = false
    }
}