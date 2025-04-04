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
import tg.eplcoursandroid.campusgeo.adapter.InfraFragmentAdapter
import tg.eplcoursandroid.campusgeo.adapter.Infra
import tg.eplcoursandroid.campusgeo.adapter.InfraAdapter

class AllInfraFragment : Fragment(), SearchBarFragment.SearchListener {

    private lateinit var infrasAll: List<Infra>
    private lateinit var filteredList: MutableList<Infra>
    private lateinit var adapter: InfraFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_all_infra, container, false)

        infrasAll = listOf(
            Infra("Infra A", "Campus All","500m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
        )
        filteredList = infrasAll.toMutableList()

        adapter = InfraFragmentAdapter(infrasAll)
        val recyclerAllInfra = view.findViewById<RecyclerView>(R.id.recyclerAllInfra)
        recyclerAllInfra.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerAllInfra.adapter = adapter

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
        filteredList = infrasAll.filter { it.nom.contains(query, ignoreCase = true) }.toMutableList()
        adapter.updateList(filteredList)
    }

}