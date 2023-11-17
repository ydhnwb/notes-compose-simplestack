package com.ydhnwb.notesappsimplestack.screen.login

import com.jakewharton.rxrelay2.BehaviorRelay
import com.ydhnwb.notesappsimplestack.app.module.AuthManager
import com.ydhnwb.notesappsimplestack.core.model.UserInfoModel
import com.ydhnwb.notesappsimplestack.util.get
import com.ydhnwb.notesappsimplestack.util.isValidEmail
import com.ydhnwb.notesappsimplestack.util.set
import com.zhuinden.rxvalidatebykt.validateBy
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestack.Bundleable
import com.zhuinden.simplestack.ScopedServices
import com.zhuinden.statebundle.StateBundle
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy

class LoginViewModel(
    private val authManager: AuthManager,
    private val backstack: Backstack
) : Bundleable, ScopedServices.Registered {

    private val compositeDisposable = CompositeDisposable()
    val email = BehaviorRelay.createDefault("")
    val password = BehaviorRelay.createDefault("")

    val alertDialog = BehaviorRelay.createDefault(false)

    // listen to other state
    private val isEmailValidRelay = BehaviorRelay.createDefault(false)
    val isEmailValid : Observable<Boolean> = isEmailValidRelay

    private val isPasswordValidRelay = BehaviorRelay.createDefault(false)
    val isPasswordValid : Observable<Boolean> = isPasswordValidRelay

    fun onBackIconButtonClick() {
        alertDialog.set(false)
        backstack.goBack()
    }

    fun onLoginClick(){
        alertDialog.set(false)
        // dummy correct login
        if(email.value.equals("yudhanewbie@gmail.com") && password.value.equals("yudhanewbie")){
            authManager.saveRegistration(UserInfoModel("1", "Prieyuda Akadita S.", "Hello world").toString())
        }else{
            alertDialog.set(true)
        }
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

    override fun onServiceRegistered() {
        validateBy(
            email.map { it.isNotEmpty() && isValidEmail(it) },
        ).subscribeBy { isEnabled ->
            isEmailValidRelay.set(isEnabled)
        }.addTo(compositeDisposable)

        validateBy(
            password.map { it.isNotEmpty() && it.length >= 6 }
        ).subscribeBy { isEnabled ->
            isPasswordValidRelay.set(isEnabled)
        }.addTo(compositeDisposable)
    }

    override fun onServiceUnregistered() {
        compositeDisposable.clear()
    }
}