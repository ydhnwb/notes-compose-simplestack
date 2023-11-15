package com.ydhnwb.notesappsimplestack.screen.register

import androidx.fragment.app.Fragment
import com.ydhnwb.notesappsimplestack.app.FragmentKey
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.servicesktx.add
import kotlinx.parcelize.Parcelize

@Parcelize
data object RegisterKey : FragmentKey() {
    override fun instantiateFragment(): Fragment {
        return RegisterFragment()
    }

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder){
            add(RegisterViewModel(backstack))
        }
    }
}