package com.ydhnwb.notesappsimplestack.screen.home

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun BottomNavigation() {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Explore,
        BottomNavItem.Saved,
        BottomNavItem.Profile
    )

    NavigationBar {
        items.forEach { item ->
            AddItem(
                screen = item
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem
) {
    NavigationBarItem(
        label = { Text(text = stringResource(screen.title)) },
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = stringResource(id = screen.title)
            )
        },
        selected = true,
        alwaysShowLabel = true,
        onClick = { /*TODO*/ },
        colors = NavigationBarItemDefaults.colors()
    )
}