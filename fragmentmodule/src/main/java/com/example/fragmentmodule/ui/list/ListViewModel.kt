package com.example.fragmentmodule.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fragmentmodule.data.BogotaRepository
import com.example.fragmentmodule.model.Bogota
import com.example.fragmentmodule.model.BogotaItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {

    private var bogotaLoad : MutableLiveData<ArrayList<BogotaItem>> = MutableLiveData()
    val onBogotaLoaded: LiveData<ArrayList<BogotaItem>> = bogotaLoad

    private val repository = BogotaRepository()

    fun getBogotaFromServer(){
        GlobalScope.launch(Dispatchers.IO) {
            bogotaLoad.postValue(repository.getBogota())
        }
    }


    fun loadMockBogotaFromJson(bogotaString: InputStream?) {
        val bogotaString = bogotaString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        bogotaLoad.value = gson.fromJson(bogotaString, Bogota::class.java)
    }
}