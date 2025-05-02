package com.finding_a_partner.authservice.service

import com.finding_a_partner.authservice.entity.User
import com.finding_a_partner.authservice.model.RegisterRequest
import com.finding_a_partner.authservice.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService {

    override fun registerUser(registerRequest: RegisterRequest): User {
        userRepository.findByUsername(registerRequest.username)?.let {
            throw IllegalArgumentException("Пользователь с таким username уже существует.")
        }
        val user = User(
            username = registerRequest.username,
            email = registerRequest.email,
            password = passwordEncoder.encode(registerRequest.password)
        )
        return userRepository.save(user)
    }

    override fun authenticate(username: String, password: String): User? {
        val user = userRepository.findByUsername(username)
        return if (user != null && passwordEncoder.matches(password, user.password)) {
            user
        } else {
            null 
        }
    }
}
