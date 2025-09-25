package com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects

import org.junit.Test
import org.junit.Assert.*

class EmailTest {

    @Test
    fun `given valid email when creating Email then should succeed`() {

        val validEmail = "fernando.garcia@ucb.edu.bo"

        // When
        val email = Email(validEmail)


        assertEquals(validEmail, email.value)
        assertEquals(validEmail, email.toString())
    }

    @Test
    fun `given valid gmail when creating Email then should succeed`() {

        val validEmail = "test@gmail.com"


        val email = Email(validEmail)


        assertEquals(validEmail, email.value)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `given blank email when creating Email then should throw exception`() {
        Email("")
    }

}