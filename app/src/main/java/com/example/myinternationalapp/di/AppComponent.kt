package com.example.myinternationalapp

import com.example.myinternationalapp.di.NetworkDependency
import com.example.myinternationalapp.di.repositoryDependency
import com.example.myinternationalapp.di.roomModule
import com.example.myinternationalapp.di.useCases
import com.example.myinternationalapp.di.viewModelDependency

/**
 * Root DI component with list of multiple dependencies.
 */
val appComponent = listOf(
    repositoryDependency,
    useCases,
    viewModelDependency,
    NetworkDependency,
    roomModule
)
