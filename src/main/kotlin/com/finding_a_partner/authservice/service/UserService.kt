package com.finding_a_partner.authservice.service

import com.finding_a_partner.authservice.entity.User
import com.finding_a_partner.authservice.model.RegisterRequest

interface UserService {
    fun registerUser(registerRequest: RegisterRequest): User

    fun authenticate(username: String, password: String): User?
}
