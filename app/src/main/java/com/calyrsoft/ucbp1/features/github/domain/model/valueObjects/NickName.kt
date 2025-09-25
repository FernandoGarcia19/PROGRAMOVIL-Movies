package com.calyrsoft.ucbp1.features.github.domain.model.valueObjects

@JvmInline
value class NickName(val value: String) {
    init {
        require(value.isNotBlank()) { "NickName cannot be blank" }
        require(value.length >= 3) { "NickName must be at least 3 characters long" }
        require(value.length <= 25) { "NickName must be at most 10 characters long" }
        require(value.all { it.isLetterOrDigit() }) { "NickName must only contain letters and digits" }

    }
    override fun toString(): String = value

}