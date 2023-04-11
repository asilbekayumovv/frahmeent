package uz.it_teacher.lessonmenu

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import uz.it_teacher.lessonmenu.databinding.FragmentHomeBinding
import uz.it_teacher.lessonmenu.ui.MainFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    lateinit var toolbar: Toolbar
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        toolbar = binding.toolbar
        val mainFragment = MainFragment()
        val settingsFragment = SettingsFragment()
        val personFragment = PersonFragment()
        setCurrentFragment(personFragment)

        val activity: AppCompatActivity = getActivity() as AppCompatActivity
        activity.setSupportActionBar(toolbar)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener() {
            when (it.itemId) {
                R.id.main -> {
                    setCurrentFragment(mainFragment)
                    true
                }
                R.id.person -> {
                    setCurrentFragment(personFragment)
                    true
                }
                R.id.settings -> {
                    setCurrentFragment(settingsFragment)
                    true
                }

                else -> {
                    true
                }
            }
        }
        return binding.root
    }

    private fun setCurrentFragment(fragment: Fragment) =
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                findNavController().navigate(R.id.action_homeFragment_to_cabinetFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
