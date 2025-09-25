package com.calyrsoft.ucbp1.features.profile.domain.model

import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.Description
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.Email
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.FullName
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.PhoneNumber

data class ProfileModel(
    val nombre: FullName, 
    val correo: Email, 
    val numero: PhoneNumber, 
    val descripcion: Description
)