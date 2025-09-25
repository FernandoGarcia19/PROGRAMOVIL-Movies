package com.calyrsoft.ucbp1.features.profile.data.repository

import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.Description
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.Email
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.FullName
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.PhoneNumber
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository

class ProfileRepository : IProfileRepository {
    override fun getUserProfile(): Result<ProfileModel> {
        return try {
            Result.success(
                ProfileModel(
                    nombre = FullName("Fernando Garcia"),
                    correo = Email("fernando.garcia@ucb.edu.bo"),
                    numero = PhoneNumber("76990995"),
                    descripcion = Description("Estudiante de Ing. De Sistemas")
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}