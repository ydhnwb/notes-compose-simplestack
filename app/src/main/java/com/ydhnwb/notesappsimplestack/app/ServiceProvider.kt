package com.ydhnwb.notesappsimplestack.app

import com.zhuinden.simplestack.ServiceBinder
import com.zhuinden.simplestackextensions.services.DefaultServiceProvider

class ServiceProvider : DefaultServiceProvider() {
    override fun bindServices(serviceBinder: ServiceBinder) {
        super.bindServices(serviceBinder)
        val scope = serviceBinder.scopeTag
        with(serviceBinder){
            when (scope) {
                //TODO: add viewmodel dependencies
//                RegistrationViewModel::class.java.name -> {
//                    add(RegistrationViewModel(lookup(), backstack))
//                }
                else -> {}
            }

        }
    }
}