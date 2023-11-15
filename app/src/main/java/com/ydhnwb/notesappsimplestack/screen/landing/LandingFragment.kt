package com.ydhnwb.notesappsimplestack.screen.landing

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.ydhnwb.notesappsimplestack.app.theme.NotesAppSimpleStack
import com.ydhnwb.notesappsimplestack.core.ComposeFragment
import com.zhuinden.simplestack.Backstack
import com.zhuinden.simplestackextensions.servicesktx.lookup

class LandingFragment : ComposeFragment(){
    @Composable
    override fun FragmentComposable(backstack: Backstack) {
        val viewModel = remember { backstack.lookup<LandingViewModel>() }
        NotesAppSimpleStack{
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ){
                LandingScreen(viewModel)
            }
        }
    }
}