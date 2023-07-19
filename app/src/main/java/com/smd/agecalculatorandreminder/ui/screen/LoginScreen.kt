package com.smd.agecalculatorandreminder.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smd.agecalculatorandreminder.LoginEvent
import com.smd.agecalculatorandreminder.LoginState
import com.smd.agecalculatorandreminder.R
import com.smd.agecalculatorandreminder.ui.theme.Gray01
import com.smd.agecalculatorandreminder.ui.theme.interBold
import com.smd.agecalculatorandreminder.ui.theme.interNormal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    state: LoginState,
    onEvent: (LoginEvent) -> Unit
) {
    //var username by remember { mutableStateOf("") }
    //var password by remember { mutableStateOf("") }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF181A1F))
            .padding(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.welcome_back),
                    color = Color.White,
                    fontFamily = interBold,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = stringResource(id = R.string.please_sign_in_to_your_account),
                    color = Gray01,
                    fontSize = 15.sp,
                    fontFamily = interNormal
                )
                Spacer(modifier = Modifier.height(30.dp))
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color(0xFF262A34))
                        .padding(start = 10.dp)

                ) {
                    TextField(
                        value = state.username,
                        onValueChange = {
                            onEvent(LoginEvent.SetUsername(it))
                        },
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White,
                            fontFamily = interNormal
                        ),
                        singleLine = true,
                        maxLines = 1,
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.username),
                                color = Gray01,
                                fontSize = 16.sp,
                                fontFamily = interNormal
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    contentAlignment = Alignment.CenterStart,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color(0xFF262A34))
                        .padding(start = 10.dp)

                ) {
                    TextField(
                        value = state.password,
                        onValueChange = {
                            onEvent(LoginEvent.SetPassword(it))
                        },
                        textStyle = TextStyle(
                            fontSize = 16.sp,
                            color = Color.White,
                            fontFamily = interNormal
                        ),
                        singleLine = true,
                        maxLines = 1,
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.password),
                                color = Gray01,
                                fontSize = 16.sp,
                                fontFamily = interNormal,
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    ClickableText(
                        onClick = {
                            onEvent(LoginEvent.ForgotPassword)
                        },
                        text = AnnotatedString(stringResource(id = R.string.forgot_password)),
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Gray01,
                            fontFamily = interNormal,
                            fontStyle = FontStyle.Italic
                        )

                        /*fontSize = 14.sp,
                        color = Gray01,
                        fontFamily = interNormal,
                        fontStyle = FontStyle.Italic,*/

                    )
                }
                Spacer(modifier = Modifier.height(36.dp))
                Button(
                    onClick = {
                        onEvent(LoginEvent.SignIn(state.username, state.password))
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color(0xFF5467FF))
                ) {
                    Text(
                        text = stringResource(id = R.string.sign_in),
                        color = Color.White,
                        fontFamily = interBold,
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        onEvent(LoginEvent.SignInWithGoogle)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color.White)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_google_logo),
                        contentDescription = "Google Button",
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = stringResource(id = R.string.sign_in_with_google),
                        color = Color(0xFF181A1F),
                        fontFamily = interBold,
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        onEvent(LoginEvent.SignInWithFacebook)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Color(0xFF3A579B))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_fb_logo),
                        contentDescription = "Facebook Button",
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = stringResource(id = R.string.sign_in_with_facebook),
                        color = Color.White,
                        fontFamily = interBold,
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = stringResource(id = R.string.dont_have_an_account),
                        color = Color.White,
                        fontFamily = interNormal,
                        fontSize = 14.sp,
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        color = Color(0xFF4251BC),
                        fontFamily = interBold,
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(
        state = LoginState(),
        onEvent = {}
    )
}