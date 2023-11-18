package com.ydhnwb.notesappsimplestack.app

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ydhnwb.notesappsimplestack.R
import com.ydhnwb.notesappsimplestack.app.module.AuthManager
import com.ydhnwb.notesappsimplestack.core.FragmentStateChanger
import com.ydhnwb.notesappsimplestack.screen.home.HomeKey
import com.ydhnwb.notesappsimplestack.screen.landing.LandingKey
import com.ydhnwb.notesappsimplestack.screen.login.LoginKey
import com.zhuinden.simplestack.History
import com.zhuinden.simplestack.SimpleStateChanger
import com.zhuinden.simplestack.StateChange
import com.zhuinden.simplestack.navigator.Navigator
import com.zhuinden.simplestackextensions.navigatorktx.androidContentFrame
import com.zhuinden.simplestackextensions.servicesktx.get

class MainActivity : AppCompatActivity(), SimpleStateChanger.NavigationHandler {
    private lateinit var fragmentStateChanger: FragmentStateChanger
    private lateinit var authManager: AuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupFragmentStateChanger()

    }

    private fun setupFragmentStateChanger() {
        val app = application as App
        authManager = app.globalServices.get()

        fragmentStateChanger = FragmentStateChanger(supportFragmentManager, R.id.container)
        Navigator.configure()
            .setStateChanger(SimpleStateChanger(this@MainActivity))
            .setScopedServices(ServiceProvider())
            .setGlobalServices(app.globalServices)
            .install(this@MainActivity, androidContentFrame, History.of(
                when{
//                    authManager.isLoggedIn() -> {}
                    else -> HomeKey
                }
            ))
    }

    override fun onNavigationEvent(stateChange: StateChange) {
        fragmentStateChanger.handleStateChange(stateChange)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if(!Navigator.onBackPressed(this)){
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        if(isFinishing){
            println("isFinishing")
//            authManager.clearRegistration()
        }
        super.onDestroy()
    }
}