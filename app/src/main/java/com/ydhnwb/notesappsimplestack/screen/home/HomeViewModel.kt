package com.ydhnwb.notesappsimplestack.screen.home

import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.Bundleable
import com.zhuinden.simplestack.ScopedServices
import com.zhuinden.statebundle.StateBundle

class HomeViewModel (
    private val backstack: Backstack
): Bundleable, ScopedServices.Registered {
    override fun toBundle(): StateBundle {
        return StateBundle()
    }

    override fun fromBundle(bundle: StateBundle?) {
    }

    override fun onServiceRegistered() {
    }

    override fun onServiceUnregistered() {
    }
}