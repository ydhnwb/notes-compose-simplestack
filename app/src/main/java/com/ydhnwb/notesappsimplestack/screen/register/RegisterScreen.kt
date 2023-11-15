package com.ydhnwb.notesappsimplestack.screen.register

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rxjava2.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ydhnwb.notesappsimplestack.R
import com.ydhnwb.notesappsimplestack.util.set

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen (
    viewModel: RegisterViewModel
){
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize(),
    ) {
        IconButton(
            onClick = viewModel::onBackButtonClick
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = stringResource(R.string.back)
            )

        }
        Column (
            modifier = Modifier.padding(16.dp)
        ) {
            Text(stringResource(R.string.create_an_account),
                fontSize = 32.sp,
                modifier = Modifier.padding(0.dp, 8.dp),
                maxLines = 1
            )
            Text(stringResource(R.string.create_an_account_descrription))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column (
            modifier = Modifier.padding(16.dp)
        ) {
            TextField(
                value = viewModel.name.subscribeAsState(initial = "").value,
                onValueChange = viewModel.name::set,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.placeholder_name)) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewModel.email.subscribeAsState(initial = "").value,
                onValueChange = viewModel.email::set,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.placeholder_email)) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewModel.bio.subscribeAsState(initial = "").value,
                onValueChange = viewModel.bio::set,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.placeholder_bio)) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = viewModel.password.subscribeAsState(initial = "").value,
                onValueChange = viewModel.password::set,
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.placeholder_password)) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                ,
                onClick = {  }
            ) {
                Text(stringResource(id = R.string.create_an_account))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                stringResource(R.string.terms_and_condition),
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }


    }
}