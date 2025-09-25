package com.calyrsoft.ucbp1.features.github.domain.model.valueObjects

@JvmInline
value class UrlPath(val value: String) {
    init {
        require(value.isNotBlank()) { "UrlPath cannot be blank" }
        require(value.length >= 3) { "UrlPath must be at least 3 characters long" }
        require(value.startsWith("https://")) { "UrlPath must start with https" }
    }
    override fun toString(): String = value
}