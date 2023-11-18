package com.ydhnwb.notesappsimplestack.screen.home

import androidx.fragment.app.Fragment
import com.ydhnwb.notesappsimplestack.app.FragmentKey
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.servicesktx.add
import kotlinx.parcelize.Parcelize

@Parcelize
data object HomeKey: FragmentKey() {
    override fun instantiateFragment(): Fragment {
        return HomeFragment()
    }

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder){
            add(HomeViewModel(backstack))
        }
    }

}