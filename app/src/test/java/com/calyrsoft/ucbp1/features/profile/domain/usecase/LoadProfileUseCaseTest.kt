package com.calyrsoft.ucbp1.features.profile.domain.usecase

import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.Description
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.Email
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.FullName
import com.calyrsoft.ucbp1.features.profile.domain.model.valueObjects.PhoneNumber
import com.calyrsoft.ucbp1.features.profile.domain.repository.IProfileRepository
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.junit.Rule

class LoadProfileUseCaseTest {
    
    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()
    
    @Mock
    private lateinit var mockRepository: IProfileRepository
    
    @Test
    fun `given repository returns success when invoke is called then should return success result`() = runTest {
        val expectedProfile = ProfileModel(
            nombre = FullName("Fernando Garcia"),
            correo = Email("fernando.garcia@ucb.edu.bo"),
            numero = PhoneNumber("76990995"),
            descripcion = Description("Estudiante de Ing. De Sistemas")
        )
        `when`(mockRepository.getUserProfile()).thenReturn(Result.success(expectedProfile))
        
        val useCase = loadProfileUseCase(mockRepository)

        val result = useCase.invoke()
        

        assertTrue(result.isSuccess)
        assertEquals(expectedProfile, result.getOrNull())
        verify(mockRepository, times(1)).getUserProfile()
    }

}