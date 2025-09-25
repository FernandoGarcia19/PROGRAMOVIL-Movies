package com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects

@JvmInline
value class FullName(val value: String) {
    init {
        require(value.isNotBlank()) { "FullName cannot be blank" }
        require(value.length >= 2) { "FullName must be at least 2 characters long" }
        require(value.length <= 100) { "FullName must be at most 100 characters long" }
        require(value.trim() == value) { "FullName cannot have leading or trailing whitespace" }
        require(value.all { it.isLetter() || it.isWhitespace() }) { "FullName must only contain letters and spaces" }
        require(value.split(" ").size >= 2) { "FullName must contain at least two words" }
    }
    
    override fun toString(): String = value
}