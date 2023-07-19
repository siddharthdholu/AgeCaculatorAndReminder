package com.smd.agecalculatorandreminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.smd.agecalculatorandreminder.ui.screen.LoginScreen
import com.smd.agecalculatorandreminder.ui.theme.AgeCalculatorAndReminderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AgeCalculatorAndReminderTheme {
                val viewModel: LoginViewModel = hiltViewModel()
                val state by viewModel.state.collectAsState()
                //val scaffoldState by rememberScaffoldState()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(state = state, onEvent = viewModel::onEvent)
                }
            }
        }
    }
}