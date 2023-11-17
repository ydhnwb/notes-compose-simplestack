package com.ydhnwb.notesappsimplestack.screen.register

import com.jakewharton.rxrelay2.BehaviorRelay
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

class RegisterViewModel(
    private val backStack: Backstack
): Bundleable, ScopedServices.Registered {
    private val compositeDisposable = CompositeDisposable()
    val name = BehaviorRelay.createDefault("")
    val email = BehaviorRelay.createDefault("")
    val bio = BehaviorRelay.createDefault("")
    val password = BehaviorRelay.createDefault("")

    val alertDialog = BehaviorRelay.createDefault(false)

    private val nameIsValidRelay = BehaviorRelay.createDefault(false)
    val nameIsValid : Observable<Boolean> =  nameIsValidRelay

    private val emailIsValidRelay = BehaviorRelay.createDefault(false)
    val emailIsValid : Observable<Boolean> = emailIsValidRelay

    private val bioIsValidRelay = BehaviorRelay.createDefault(false)
    val bioIsValid: Observable<Boolean> = bioIsValidRelay

    private val isPasswordValidRelay = BehaviorRelay.createDefault(false)
    val isPasswordValid : Observable<Boolean> = isPasswordValidRelay


    fun onRegisterClick(){
        // Just make it true for now.
        alertDialog.set(true)
    }

    fun onBackButtonClick(){
        backStack.goBack()
    }

    fun resetForm(){
        name.set("")
        email.set("")
        bio.set("")
        password.set("")
    }

    fun onDialogOKClick(){
        resetForm()
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

    override fun onServiceRegistered() {
        validateBy(name.map { it.isNotEmpty() }).subscribeBy { isEnabled ->
            nameIsValidRelay.set(isEnabled)
        }.addTo(compositeDisposable)

        validateBy(email.map { it.isNotEmpty() && isValidEmail(it) }).subscribeBy { isEnabled ->
            emailIsValidRelay.set(isEnabled)
        }.addTo(compositeDisposable)

        validateBy(bio.map { it.isNotEmpty() }).subscribeBy { isEnabled ->
            bioIsValidRelay.set(isEnabled)
        }.addTo(compositeDisposable)

        validateBy(password.map { it.isNotEmpty() && it.length >= 6 }).subscribeBy { isEnabled ->
            isPasswordValidRelay.set(isEnabled)
        }.addTo(compositeDisposable)
    }

    override fun onServiceUnregistered() {
        compositeDisposable.clear()
    }
}