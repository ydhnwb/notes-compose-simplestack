package com.ydhnwb.notesappsimplestack.app

import android.app.Application
import androidx.preference.PreferenceManager
import com.ydhnwb.notesappsimplestack.app.module.AuthManager
import com.zhuinden.simplestack.GlobalServices
import com.zhuinden.simplestackextensions.servicesktx.add


class App: Application() {
    lateinit var globalServices: GlobalServices
        private set

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val authenticationManager = AuthManager(sharedPreferences)
        globalServices = GlobalServices.builder()
            .add(authenticationManager)
            .build()
    }
}