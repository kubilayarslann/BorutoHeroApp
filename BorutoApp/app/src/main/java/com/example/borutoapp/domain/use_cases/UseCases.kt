package com.example.borutoapp.domain.use_cases

import com.example.borutoapp.domain.use_cases.read_onboarding.ReadOnBoardingState
import com.example.borutoapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase


data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingState: ReadOnBoardingState
)
