import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import tg.eplcoursandroid.campusgeo.R

object FragmentUtils {
    fun ouvrirFragment(fragmentManager: FragmentManager, newFragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, newFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}