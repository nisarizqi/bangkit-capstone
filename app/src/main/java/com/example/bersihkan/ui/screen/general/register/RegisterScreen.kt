package com.example.bersihkan.ui.screen.general.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bersihkan.R
import com.example.bersihkan.ui.components.ClickableText
import com.example.bersihkan.ui.components.EmailTextField
import com.example.bersihkan.ui.components.LoginRegisterSection
import com.example.bersihkan.ui.components.NameTextField
import com.example.bersihkan.ui.components.PasswordTextField
import com.example.bersihkan.ui.components.PhoneNumberTextField
import com.example.bersihkan.ui.components.TextFieldContent
import com.example.bersihkan.ui.theme.BersihKanTheme
import com.example.bersihkan.ui.theme.BlueLagoon
import com.example.bersihkan.ui.theme.Java
import com.example.bersihkan.ui.theme.textMediumExtraSmall
import com.example.bersihkan.utils.isEmailValid
import com.example.bersihkan.utils.isPasswordValid

@Composable
fun RegisterScreen() {

}

@Composable
fun RegisterContent(
    inputName: String,
    onNameChange: (String) -> Unit,
    inputEmail: String,
    errorEmail: Boolean,
    onEmailChange: (String) -> Unit,
    inputPhoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    inputPassword: String,
    errorPassword: Boolean,
    onPasswordChange: (String) -> Unit,
    inputConfirmPassword: String,
    errorConfirmPassword: Boolean,
    onConfirmPasswordChange: (String) -> Unit,
    navigateToLogin: () -> Unit,
    registerOnClick: () -> Unit,
    modifier: Modifier = Modifier
){

    LazyColumn(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        item {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(200.dp)
                    .padding(bottom = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = "BersihKan App Logo",
                    modifier = Modifier
                        .size(130.dp)
                )
            }
        }
        item {
            LoginRegisterSection(
                title = stringResource(id = R.string.register),
                description = stringResource(id = R.string.register_desc)
            )
        }
        item {
            Divider(
                thickness = 2.dp,
                color = BlueLagoon,
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 30.dp)
                    .width(170.dp)
            )
        }
        item {
            TextFieldContent(
                title = stringResource(R.string.name),
                content = {
                    NameTextField(
                        input = inputName,
                        onInputChange = onNameChange
                    )
                }
            )
        }
        item {
            TextFieldContent(
                title = stringResource(id = R.string.email),
                content = {
                    EmailTextField(
                        input = inputEmail,
                        onInputChange = onEmailChange,
                        isError = errorEmail
                    )
                }
            )
        }
        item {
            TextFieldContent(
                title = stringResource(R.string.phone_number),
                content = {
                    PhoneNumberTextField(
                        input = inputPhoneNumber,
                        onInputChange = onPhoneNumberChange
                    )
                }
            )
        }
        item {
            TextFieldContent(
                title = stringResource(R.string.password),
                content = {
                    PasswordTextField(
                        input = inputPassword,
                        onInputChange = onPasswordChange,
                        isError = errorPassword,
                        placeholderText = stringResource(id = R.string.enter_password)
                    )
                }
            )
        }
        item {
            TextFieldContent(
                title = stringResource(R.string.confirm_password),
                content = {
                    PasswordTextField(
                        input = inputConfirmPassword,
                        onInputChange = onConfirmPasswordChange,
                        isError = errorConfirmPassword,
                        placeholderText = stringResource(id = R.string.enter_confirm_password)
                    )
                }
            )
        }
        item {
            ClickableText(
                text = stringResource(id = R.string.already_have_an_account),
                clickableText = stringResource(id = R.string.login),
                onClick = navigateToLogin,
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }
        item {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = registerOnClick,
                    modifier = Modifier
                        .padding(6.dp, 2.dp)
                ) {
                    Text(text = stringResource(id = R.string.register))
                }
            }
        }

    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RegisterContentPreview() {

    var inputName by remember {
        mutableStateOf("")
    }
    var inputEmail by remember {
        mutableStateOf("")
    }
    var errorEmail by remember {
        mutableStateOf(false)
    }
    var inputPassword by remember {
        mutableStateOf("")
    }
    var errorPassword by remember {
        mutableStateOf(false)
    }
    var inputConfirmPassword by remember {
        mutableStateOf("")
    }
    var errorConfirmPassword by remember {
        mutableStateOf(false)
    }
    var inputPhoneNumber by remember {
        mutableStateOf("")
    }

    BersihKanTheme {
        RegisterContent(
            inputName = inputName,
            onNameChange = { newValue ->
                inputName = newValue
            },
            inputEmail = inputEmail,
            errorEmail = errorEmail,
            onEmailChange = { newValue ->
                inputEmail = newValue
                errorEmail = !isEmailValid(inputEmail)
            },
            inputPhoneNumber = inputPhoneNumber,
            onPhoneNumberChange = { newValue ->
                inputPhoneNumber = newValue
            },
            inputPassword = inputPassword,
            errorPassword = errorPassword,
            onPasswordChange = { newValue ->
                inputPassword = newValue
                errorPassword = !isPasswordValid(inputPassword)
            },
            inputConfirmPassword = inputConfirmPassword,
            errorConfirmPassword = errorConfirmPassword,
            onConfirmPasswordChange = { newValue ->
                inputConfirmPassword = newValue
                errorConfirmPassword = !isPasswordValid(inputConfirmPassword)
            },
            navigateToLogin = {},
            registerOnClick = {},
        )
    }

}