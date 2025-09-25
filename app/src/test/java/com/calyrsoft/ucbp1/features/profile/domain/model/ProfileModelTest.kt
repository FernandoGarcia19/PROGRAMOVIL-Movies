package com.calyrsoft.ucbp1.features.profile.domain.model

import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.Description
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.Email
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.FullName
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.PhoneNumber
import org.junit.Test
import org.junit.Assert.*

class ProfileModelTest {
    
    @Test
    fun `given valid parameters when creating ProfileModel then should succeed`() {
        val fullName = FullName("Fernando Garcia")
        val email = Email("fernando.garcia@ucb.edu.bo")
        val phoneNumber = PhoneNumber("76990995")
        val description = Description("Estudiante de Ing. De Sistemas")

        val profile = ProfileModel(
            nombre = fullName,
            correo = email,
            numero = phoneNumber,
            descripcion = description
        )

        assertEquals(fullName, profile.nombre)
        assertEquals(email, profile.correo)
        assertEquals(phoneNumber, profile.numero)
        assertEquals(description, profile.descripcion)
    }
}