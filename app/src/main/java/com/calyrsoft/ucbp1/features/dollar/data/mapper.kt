package com.calyrsoft.ucbp1.features.dollar.data

import com.calyrsoft.ucbp1.features.dollar.data.database.entity.DollarEntity
import com.calyrsoft.ucbp1.features.dollar.domain.model.DollarModel

fun DollarEntity.toModel() : DollarModel {
    return DollarModel(
        oficial = dollarOfficial,
        paralelo = dollarParallel
    )
}
fun DollarModel.toEntity() : DollarEntity {
    val entity = DollarEntity()
    entity.dollarOfficial = oficial
    entity.dollarParallel = paralelo
    return entity
}