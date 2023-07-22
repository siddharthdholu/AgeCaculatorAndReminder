package com.smd.agecalculatorandreminder.base

sealed interface UiEvent {
    data class Navigate(val route: String) : UiEvent
    data class Error(val message: String) : UiEvent
}