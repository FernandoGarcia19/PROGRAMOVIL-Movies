package com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects

import org.junit.Test
import org.junit.Assert.*

class PhoneNumberTest {
    
    @Test
    fun `given valid phone number when creating PhoneNumber then should succeed`() {
        val validPhone = "76990995"

        val phoneNumber = PhoneNumber(validPhone)

        assertEquals(validPhone, phoneNumber.value)
        assertEquals(validPhone, phoneNumber.toString())
    }

}