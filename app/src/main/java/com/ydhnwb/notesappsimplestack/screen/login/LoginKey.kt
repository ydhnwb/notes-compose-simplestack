package com.ydhnwb.notesappsimplestack.screen.login

import androidx.fragment.app.Fragment
import com.ydhnwb.notesappsimplestack.app.FragmentKey
import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.servicesktx.add
import com.zhuinden.simplestackextensions.servicesktx.lookup
import kotlinx.parcelize.Parcelize


@Parcelize
data object LoginKey: FragmentKey() {
    override fun instantiateFragment(): Fragment {
        return LoginFragment()
    }

    override fun bindServices(serviceBinder: ServiceBinder) {
        with(serviceBinder){
            add(LoginViewModel(lookup(), backstack))
        }
    }
}