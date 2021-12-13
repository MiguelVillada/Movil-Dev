package com.example.fragmentmodule.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fragmentmodule.databinding.FragmentListBinding
import com.example.fragmentmodule.model.BogotaItem


class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var bogotaAdapter: BogotaAdapter
    private var listBogota: ArrayList<BogotaItem> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]

        return listBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //listViewModel.loadMockBogotaFromJson(context?.assets?.open("poibogota.json"))

        listViewModel.getBogotaFromServer()

        listViewModel.onBogotaLoaded.observe(viewLifecycleOwner, { result ->
            onBogotaLoadedSubscribe(result)
        })

        bogotaAdapter = BogotaAdapter(listBogota, onItemClicked = { onBogotaClicked(it) } )

        listBinding.bogotaRecyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = bogotaAdapter
            setHasFixedSize(false)
        }

    }

    private fun onBogotaLoadedSubscribe(result: ArrayList<BogotaItem>?) {
        result?.let { listBogota ->
            bogotaAdapter.appendItems(listBogota)
        }
    }

    private fun onBogotaClicked(bogota: BogotaItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poibogota = bogota))
    }

}