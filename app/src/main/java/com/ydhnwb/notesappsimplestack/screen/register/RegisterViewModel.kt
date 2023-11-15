package com.ydhnwb.notesappsimplestack.screen.register

import com.jakewharton.rxrelay2.BehaviorRelay
import com.ydhnwb.notesappsimplestack.util.get
import com.ydhnwb.notesappsimplestack.util.set
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.Bundleable
import com.zhuinden.simplestack.ScopedServices
import com.zhuinden.statebundle.StateBundle
import io.reactivex.disposables.CompositeDisposable

class RegisterViewModel(
    private val backStack: Backstack
): Bundleable, ScopedServices.Registered {
    private val compositeDisposable = CompositeDisposable()
    val name = BehaviorRelay.createDefault("")
    val email = BehaviorRelay.createDefault("")
    val bio = BehaviorRelay.createDefault("")
    val password = BehaviorRelay.createDefault("")

    fun onBackButtonClick(){
        backStack.goBack()
    }

    override fun toBundle(): StateBundle {
        return StateBundle().apply {
            putString("email", email.get())
            putString("name", name.get())
            putString("bio", bio.get())
            putString("password", password.get())
        }
    }

    override fun fromBundle(bundle: StateBundle?) {
        bundle?.run {
            name.set(getString("name", ""))
            email.set(getString("email", ""))
            bio.set(getString("bio", ""))
            password.set(getString("password", ""))
        }
    }

    override fun onServiceRegistered() {}

    override fun onServiceUnregistered() {
        compositeDisposable.clear()
    }
}