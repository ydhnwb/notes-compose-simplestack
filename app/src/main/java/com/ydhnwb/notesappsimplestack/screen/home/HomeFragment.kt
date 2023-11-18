package com.ydhnwb.notesappsimplestack.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.ydhnwb.notesappsimplestack.app.theme.NotesAppSimpleStack
import com.ydhnwb.notesappsimplestack.core.ComposeFragment
import com.ydhnwb.notesappsimplestack.screen.login.LoginScreen
import com.zhuinden.simplestack.Backstack

class HomeFragment : ComposeFragment() {
    @Composable
    override fun FragmentComposable(backstack: Backstack) {
        NotesAppSimpleStack{
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ){

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigation() }
                ) { paddingValues ->
                    print(paddingValues)
                    HomeScreen()
                }
            }
        }
    }
}