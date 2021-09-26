package com.example.myinternationalapp.di

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
