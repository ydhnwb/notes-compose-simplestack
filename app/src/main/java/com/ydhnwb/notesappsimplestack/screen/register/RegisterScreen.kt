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
import androidx.compose.material.icons.filled.CheckCircle
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ydhnwb.notesappsimplestack.R
import com.ydhnwb.notesappsimplestack.screen.components.AlertPopup
import com.ydhnwb.notesappsimplestack.util.set

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun RegisterScreen (
    viewModel: RegisterViewModel
){
    val name = viewModel.name.subscribeAsState(initial = "").value
    val email = viewModel.email.subscribeAsState(initial = "").value
    val bio = viewModel.bio.subscribeAsState(initial = "").value
    val password = viewModel.password.subscribeAsState(initial = "").value
    val alertDialog = viewModel.alertDialog.subscribeAsState(initial = false).value

    val nameIsValid = viewModel.nameIsValid.subscribeAsState(initial = false).value
    val emailIsValid = viewModel.emailIsValid.subscribeAsState(initial = false).value
    val bioIsValid = viewModel.bioIsValid.subscribeAsState(initial = false).value
    val passwordIsValid = viewModel.isPasswordValid.subscribeAsState(initial = false).value


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
                value = name,
                onValueChange = viewModel.name::set,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.placeholder_name)) },
                isError = !nameIsValid && name.isNotEmpty(),
                supportingText = {
                    if (!nameIsValid && name.isNotEmpty()){
                        Text(stringResource(R.string.error_name_not_valid))
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = email,
                onValueChange = viewModel.email::set,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.placeholder_email)) },
                isError = !emailIsValid && email.isNotEmpty(),
                supportingText = {
                    if (!emailIsValid && email.isNotEmpty()){
                        Text(stringResource(R.string.error_email_not_valid), color = Color.Red)
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = bio,
                onValueChange = viewModel.bio::set,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.placeholder_bio)) },
                isError = !bioIsValid && bio.isNotEmpty(),
                supportingText = {
                    if(!bioIsValid && bio.isNotEmpty()){
                        Text(stringResource(R.string.error_bio_not_valid), color = Color.Red)
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = password,
                onValueChange = viewModel.password::set,
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(stringResource(R.string.placeholder_password)) },
                isError = !passwordIsValid && password.isNotEmpty() && password.length < 6,
                supportingText = {
                    if(!passwordIsValid && password.isNotEmpty() && password.length < 6){
                        Text(stringResource(R.string.error_password_not_valid), color = Color.Red)
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                ,
                onClick = viewModel::onRegisterClick,
                enabled = nameIsValid && emailIsValid && bioIsValid && passwordIsValid
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
    
    if(alertDialog){
        AlertPopup(
            onDismiss = {
                viewModel.resetForm()
                viewModel.alertDialog.set(false)
            },
            onOk = {
                viewModel.alertDialog.set(false)
                viewModel.onDialogOKClick()
            },
            title = stringResource(R.string.success_register),
            subTitle = stringResource(R.string.success_register_subtitle),
            icon = Icons.Filled.CheckCircle,
            onOkTitle = stringResource(R.string.ok),
            onCancelTitle = stringResource(R.string.close)
        )
    }
}