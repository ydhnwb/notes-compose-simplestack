package com.ydhnwb.notesappsimplestack.screen.landing

import com.ydhnwb.notesappsimplestack.screen.login.LoginKey
import com.ydhnwb.notesappsimplestack.screen.register.RegisterKey
import com.zhuinden.simplestack.Backstack

class LandingViewModel (
    private val backStack: Backstack
) {
    fun onSignInClick () {
        backStack.goTo(LoginKey)
    }

    fun onCreateAccountClick() {
        backStack.goTo(RegisterKey)
    }
}