package com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects

@JvmInline
value class PhoneNumber(val value: String) {
    init {
        require(value.isNotBlank()) { "PhoneNumber cannot be blank" }
        require(value.length >= 8) { "PhoneNumber must be at least 8 characters long" }
        require(value.length <= 15) { "PhoneNumber must be at most 15 characters long" }
        require(value.all { it.isDigit() }) { "PhoneNumber must only contain digits" }
    }
    
    override fun toString(): String = value
    
    fun formatted(): String {
        return when {
            value.length == 8 -> "${value.substring(0, 4)}-${value.substring(4)}"
            value.length == 10 -> "${value.substring(0, 3)}-${value.substring(3, 6)}-${value.substring(6)}"
            else -> value
        }
    }
}