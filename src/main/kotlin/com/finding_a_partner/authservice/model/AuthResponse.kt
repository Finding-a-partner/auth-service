package com.finding_a_partner.authservice.model

data class AuthResponse(
    val accessToken: String,
    val tokenType: String = "Bearer"
)
