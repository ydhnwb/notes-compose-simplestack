package com.ydhnwb.notesappsimplestack.screen.login

import com.jakewharton.rxrelay2.BehaviorRelay
import com.ydhnwb.notesappsimplestack.app.module.AuthManager
import com.ydhnwb.notesappsimplestack.util.get
import com.ydhnwb.notesappsimplestack.util.set
import com.zhuinden.rxvalidatebykt.validateBy
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.Bundleable
import com.zhuinden.simplestack.ScopedServices
import com.zhuinden.statebundle.StateBundle
import io.reactivex.disposables.CompositeDisposable

class LoginViewModel(
    private val authManager: AuthManager,
    private val backstack: Backstack
) : Bundleable, ScopedServices.Registered {

    private val compositeDisposable = CompositeDisposable()
    val email = BehaviorRelay.createDefault("")
    val password = BehaviorRelay.createDefault("")

    fun onBackIconButtonClick() {
        backstack.goBack()
    }


    /***
     * This is when confirugation change gonna happen.
     * We save current state to bundle
     * and we will restore it on fromBundle
     * */
    override fun toBundle(): StateBundle {
        return StateBundle().apply {
            putString("email", email.get())
            putString("password", password.get())
        }
    }

    override fun fromBundle(bundle: StateBundle?) {
        bundle?.run {
            email.set(getString("email", ""))
            password.set(getString("password", ""))
        }
    }

    override fun onServiceRegistered() {}

    override fun onServiceUnregistered() {
        compositeDisposable.clear()
    }
}