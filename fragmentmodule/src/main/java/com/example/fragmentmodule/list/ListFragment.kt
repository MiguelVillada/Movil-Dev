package com.example.fragmentmodule.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentmodule.databinding.FragmentListBinding
import com.example.fragmentmodule.model.Bogota
import com.example.fragmentmodule.model.BogotaItem
import com.google.gson.Gson


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var bogotaAdapter: BogotaAdapter
    private lateinit var listBogota: ArrayList<BogotaItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listBogota = loadMockBogotaFromJson()
        bogotaAdapter = BogotaAdapter(listBogota, onItemClicked = { onBogotaClicked(it) } )
    }

    private fun onBogotaClicked(bogota: BogotaItem) {

    }

    private fun loadMockBogotaFromJson(): ArrayList<BogotaItem> {
        var bogotaString: String = context?.assets?.open("poibogota.json")?.bufferedReader().use { it!!.readText() } //TODO reparar
        val gson = Gson()
        val data = gson.fromJson(bogotaString, Bogota::class.java)
        return data
    }
}