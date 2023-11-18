package com.ydhnwb.notesappsimplestack.screen.home

import com.ydhnwb.notesappsimplestack.R

sealed class BottomNavItem(
    var title: Int,
    var icon: Int
) {
    data object Home :
        BottomNavItem(
            R.string.bottom_home,
            R.drawable.baseline_home_24
        )

    data object Explore :
        BottomNavItem(
            R.string.bottom_explore,
            R.drawable.baseline_explore_24
        )

    data object Saved :
        BottomNavItem(
            R.string.bottom_saved,
            R.drawable.baseline_favorite_24
        )

    data object Profile :
        BottomNavItem(
            R.string.bottom_profile,
            R.drawable.baseline_person_4_24
        )
}