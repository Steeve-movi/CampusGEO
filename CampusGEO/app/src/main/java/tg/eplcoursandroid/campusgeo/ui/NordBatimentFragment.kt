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
import tg.eplcoursandroid.campusgeo.adapter.BatimentFragmentAdapter

class NordBatimentFragment : Fragment(), SearchBarFragment.SearchListener {

    private lateinit var batiments: List<Batiment>
    private lateinit var filteredList: MutableList<Batiment>
    private lateinit var adapter: BatimentFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_nord_batiment, container, false)

        batiments = listOf(
            Batiment("Bâtiment enseignement A", "Campus Nord", "500m", R.drawable.img),
            Batiment("Bâtiment enseignement B", "Campus Sud", "300m", R.drawable.img),
            Batiment("Bâtiment enseignement B", "Campus Sud", "300m", R.drawable.img),
            Batiment("Bâtiment enseignement B", "Campus Sud", "300m", R.drawable.img),
            Batiment("Bâtiment enseignement B", "Campus Sud", "300m", R.drawable.img),
            Batiment("Bâtiment enseignement B", "Campus Sud", "300m", R.drawable.img),
        )
        filteredList = batiments.toMutableList()

        adapter = BatimentFragmentAdapter(batiments)
        val recyclerNordBatiments = view.findViewById<RecyclerView>(R.id.recyclerNordBatiments)
        recyclerNordBatiments.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        recyclerNordBatiments.adapter = adapter

        // Inflate the layout for this fragment
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
        filteredList = batiments.filter { it.nom.contains(query, ignoreCase = true) }.toMutableList()
        adapter.updateList(filteredList)
    }

}