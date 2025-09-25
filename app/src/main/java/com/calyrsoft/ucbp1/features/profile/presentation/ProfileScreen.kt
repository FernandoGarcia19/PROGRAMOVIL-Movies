package com.calyrsoft.ucbp1.features.profile.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.calyrsoft.ucbp1.features.profile.domain.model.ProfileModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    vm: ProfileViewModel = koinViewModel()
) {
    val state by vm.state.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        when (val currentState = state) {
            is ProfileViewModel.ProfileStateUI.Init -> {
                Text("Inicializando...")
            }
            is ProfileViewModel.ProfileStateUI.Loading -> {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(16.dp))
                Text("Cargando perfil...")
            }
            is ProfileViewModel.ProfileStateUI.Error -> {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.errorContainer)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Error",
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onErrorContainer
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = currentState.message,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onErrorContainer,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = { vm.fetchProfile() }) {
                            Text("Reintentar")
                        }
                    }
                }
            }
            is ProfileViewModel.ProfileStateUI.Success -> {
                ProfileContent(profile = currentState.profile)
            }
        }
    }
}

@Composable
private fun ProfileContent(profile: ProfileModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Avatar Placeholder
            Box(
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    modifier = Modifier.fillMaxSize(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = profile.nombre.value.split(" ").mapNotNull { it.firstOrNull() }.take(2).joinToString(""),
                            style = MaterialTheme.typography.headlineLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Full Name
            Text(
                text = profile.nombre.value,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Profile Information
            ProfileInfoSection(
                title = "Información de Contacto",
                items = listOf(
                    ProfileInfoItem("Email", profile.correo.value),
                    ProfileInfoItem("Teléfono", profile.numero.formatted())
                )
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            ProfileInfoSection(
                title = "Descripción",
                items = listOf(
                    ProfileInfoItem("Sobre mí", profile.descripcion.value)
                )
            )
        }
    }
}

@Composable
private fun ProfileInfoSection(
    title: String,
    items: List<ProfileInfoItem>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        items.forEach { item ->
            ProfileInfoRow(item = item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun ProfileInfoRow(item: ProfileInfoItem) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = item.label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = item.value,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

private data class ProfileInfoItem(
    val label: String,
    val value: String
)