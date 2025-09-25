package com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects

@JvmInline
value class Email(val value: String) {
    init {
        require(value.isNotBlank()) { "Email cannot be blank" }
        require(value.length <= 320) { "Email must be at most 320 characters long" }
        require(isValidEmail(value)) { "Email must be in valid format" }
    }
    
    private fun isValidEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$".toRegex()
        return emailRegex.matches(email)
    }
    
    override fun toString(): String = value
}