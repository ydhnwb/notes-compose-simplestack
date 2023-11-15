package com.ydhnwb.notesappsimplestack.screen.landing

import androidx.fragment.app.Fragment
import com.ydhnwb.notesappsimplestack.app.FragmentKey
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.servicesktx.add
import kotlinx.parcelize.Parcelize


@Parcelize
data object LandingKey : FragmentKey(){
    override fun instantiateFragment(): Fragment {
        return LandingFragment()
    }

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder){
            add(LandingViewModel(backstack))
        }
    }
}