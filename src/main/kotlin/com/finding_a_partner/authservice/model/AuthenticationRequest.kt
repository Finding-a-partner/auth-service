package com.finding_a_partner.authservice.model

import jakarta.validation.constraints.NotBlank

data class AuthenticationRequest(
    @field:NotBlank(message = "Username не может быть пустым")
    val username: String,

    @field:NotBlank(message = "Password не может быть пустым")
    val password: String,
)
