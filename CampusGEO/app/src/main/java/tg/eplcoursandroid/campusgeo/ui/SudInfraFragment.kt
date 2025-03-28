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
import tg.eplcoursandroid.campusgeo.adapter.BatimentFragmentAdapter
import tg.eplcoursandroid.campusgeo.adapter.Infra
import tg.eplcoursandroid.campusgeo.adapter.InfraAdapter
import tg.eplcoursandroid.campusgeo.adapter.Salle
import tg.eplcoursandroid.campusgeo.adapter.InfraFragmentAdapter

class SudInfraFragment : Fragment(), SearchBarFragment.SearchListener {

    private lateinit var infrasSud: List<Infra>
    private lateinit var filteredList: MutableList<Infra>
    private lateinit var adapter: InfraFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sud_infra, container, false)

        val recyclerSudInfra = view.findViewById<RecyclerView>(R.id.recyclerSudInfra)

        infrasSud = listOf(
            Infra("Infra A", "Campus Sud","500m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
            Infra("Infra B", "Campus Sud","300m", R.drawable.img),
        )
        filteredList = infrasSud.toMutableList()

        adapter = InfraFragmentAdapter(infrasSud)
        recyclerSudInfra.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerSudInfra.adapter = adapter

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
        filteredList = infrasSud.filter { it.nom.contains(query, ignoreCase = true) }.toMutableList()
        adapter.updateList(filteredList)
    }

}