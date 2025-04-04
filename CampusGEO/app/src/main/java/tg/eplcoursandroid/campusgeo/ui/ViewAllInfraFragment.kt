package tg.eplcoursandroid.campusgeo.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import tg.eplcoursandroid.campusgeo.MainActivity
import tg.eplcoursandroid.campusgeo.R
import tg.eplcoursandroid.campusgeo.adapter.Batiment
import tg.eplcoursandroid.campusgeo.adapter.BatimentAdapter
import tg.eplcoursandroid.campusgeo.adapter.Infra
import tg.eplcoursandroid.campusgeo.adapter.InfraAdapter
import tg.eplcoursandroid.campusgeo.adapter.InfraFragmentAdapter

class ViewAllInfraFragment : Fragment(), SearchBarFragment.SearchListener {

    private lateinit var infras: List<Infra>
    private lateinit var filteredList: MutableList<Infra>
    private lateinit var adapter: InfraFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_all_infra, container, false)

        val recyclerInfra = view.findViewById<RecyclerView>(R.id.recyclerAllInfraHome)

        infras = listOf(
            Infra("Infra A", "Campus Nord","500m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
        )
        filteredList = infras.toMutableList()

        adapter = InfraFragmentAdapter(infras)
        recyclerInfra.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerInfra.adapter = adapter

        return view
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).showSearchBarFragment(this)
    }

    override fun onPause() {
        super.onPause()
        (activity as MainActivity).showSearchBarFragment(null) // Cacher la barre si on quitte
    }

    override fun onSearch(query: String) {
        filteredList = infras.filter { it.nom.contains(query, ignoreCase = true) }.toMutableList()
        adapter.updateList(filteredList)
    }

}