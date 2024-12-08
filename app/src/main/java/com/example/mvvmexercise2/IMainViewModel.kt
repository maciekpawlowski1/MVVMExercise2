package com.example.mvvmexercise2

import kotlinx.coroutines.flow.StateFlow

interface IMainViewModel {
    val state: StateFlow<MainState>
}
