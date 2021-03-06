package com.smarttoolfactory.tutorial7_2bnv_viewpager2_complexarchitecture.fragment.navhost

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.smarttoolfactory.tutorial7_2bnv_viewpager2_complexarchitecture.util.Event
import com.smarttoolfactory.tutorial7_2bnv_viewpager2_complexarchitecture.viewmodel.AppbarViewModel

/**
 * Fragment created via layout resource that belong to a layout that contains a [NavHostFragment]
 *
 * Requires a [FragmentFactory] to be able to create this fragment which does not posses
 * an empty constructor.
 *
 */
class NavHostContainerFragment(
    @LayoutRes private val layoutRes: Int,
    @IdRes private val navHostFragmentId: Int
) : Fragment() {

    private val appbarViewModel by activityViewModels<AppbarViewModel>()

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val dataBinding: ViewDataBinding = DataBindingUtil.inflate(
            inflater, layoutRes, container, false
        )

        return dataBinding.run {
            lifecycleOwner = viewLifecycleOwner
            root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(navHostFragmentId) as? NavHostFragment

        if (nestedNavHostFragment?.navController == null)
            throw RuntimeException("This fragment should have nav host with NavController")

        navController = nestedNavHostFragment.navController

    }

    override fun onResume() {
        super.onResume()

        // Set this navController as ViewModel's navController
        navController?.let {
            appbarViewModel.currentNavController.value = Event(it)
        }
    }
}