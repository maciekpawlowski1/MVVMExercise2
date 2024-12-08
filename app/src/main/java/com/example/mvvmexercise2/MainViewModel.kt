package com.example.mvvmexercise2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

class MainViewModel :
    ViewModel(),
    IMainViewModel {
    override val state: StateFlow<MainState>
        get() = TODO("Not yet implemented")
}
