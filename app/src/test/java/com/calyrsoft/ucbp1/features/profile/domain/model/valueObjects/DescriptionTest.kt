package com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects

import org.junit.Test
import org.junit.Assert.*

class DescriptionTest {
    
    @Test
    fun `given valid description when creating Description then should succeed`() {
        val validDescription = "Estudiante de Ing. De Sistemas"

        val description = Description(validDescription)
        assertEquals(validDescription, description.value)
        assertEquals(validDescription, description.toString())
    }
    
    @Test(expected = IllegalArgumentException::class)
    fun `given blank description when creating Description then should throw exception`() {
        Description("")
    }
    
    @Test(expected = IllegalArgumentException::class)
    fun `given description with only whitespace when creating Description then should throw exception`() {
        Description("   ")
    }
    
    @Test(expected = IllegalArgumentException::class)
    fun `given description too short when creating Description then should throw exception`() {
        Description("Test")
    }
}