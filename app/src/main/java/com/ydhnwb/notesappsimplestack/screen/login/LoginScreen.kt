package com.ydhnwb.notesappsimplestack.screen.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rxjava2.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ydhnwb.notesappsimplestack.R
import com.ydhnwb.notesappsimplestack.util.set


@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        IconButton(
            onClick = viewModel::onBackIconButtonClick
        ) {
            Icon(Icons.Filled.ArrowBack, contentDescription = stringResource(R.string.back))
        }
        Column(
            modifier = Modifier.padding(16.dp, 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.sign_in),
                fontSize = 32.sp,
                modifier = Modifier.padding(0.dp, 8.dp),
                maxLines = 1
            )
            Text(text = stringResource(R.string.sign_in_description))
            Spacer(modifier = Modifier.height(48.dp))
            TextField(
                value = viewModel.email.subscribeAsState(initial = "").value,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.placeholder_email)) },
                onValueChange = viewModel.email::set,
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewModel.password.subscribeAsState(initial = "").value,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.placeholder_password)) },
                onValueChange = viewModel.password::set,
                visualTransformation = remember { PasswordVisualTransformation() },
                singleLine = true,
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                onClick = {}
            ) {
                Text(stringResource(R.string.sign_in))
            }
        }


    }
}
