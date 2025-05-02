package com.finding_a_partner.authservice.model

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class RegisterRequest(
    @field:NotBlank(message = "Username не может быть пустым")
    val username: String,

    @field:Email(message = "Email должен быть валидным")
    val email: String,

    @field:NotBlank(message = "Password не может быть пустым")
    val password: String,
)
