package com.ydhnwb.notesappsimplestack.screen.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun AlertPopup(
    onDismiss: () -> Unit,
    onOk: () -> Unit,
    title: String,
    subTitle: String,
    icon: ImageVector,
    onOkTitle: String,
    onCancelTitle: String
){
    AlertDialog(
        onDismissRequest = onDismiss,
        icon = { Icon(icon, contentDescription = "") },
        title = { Text(title) },
        text = { Text(subTitle) },
        confirmButton = {
            TextButton(onClick = onOk) { Text(text = onOkTitle) }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text(text = onCancelTitle) }
        }
    )
}