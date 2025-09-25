package com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects

@JvmInline
value class Description(val value: String) {
    init {
        require(value.isNotBlank()) { "Description cannot be blank" }
        require(value.length >= 5) { "Description must be at least 5 characters long" }
        require(value.length <= 500) { "Description must be at most 500 characters long" }
        require(value.trim() == value) { "Description cannot have leading or trailing whitespace" }
    }
    
    override fun toString(): String = value
    
    fun preview(maxLength: Int = 50): String {
        return if (value.length <= maxLength) {
            value
        } else {
            value.substring(0, maxLength - 3) + "..."
        }
    }
}