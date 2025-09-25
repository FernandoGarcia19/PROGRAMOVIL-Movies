package com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects

import org.junit.Test
import org.junit.Assert.*

class FullNameTest {
    
    @Test
    fun `given valid full name when creating FullName then should succeed`() {
        val validName = "Fernando Garcia"

        val fullName = FullName(validName)

        assertEquals(validName, fullName.value)
        assertEquals(validName, fullName.toString())
    }
    
    @Test(expected = IllegalArgumentException::class)
    fun `given blank name when creating FullName then should throw exception`() {
        FullName("")
    }
    
    @Test(expected = IllegalArgumentException::class)
    fun `given name with only whitespace when creating FullName then should throw exception`() {
        FullName("   ")
    }

}