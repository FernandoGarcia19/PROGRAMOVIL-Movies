package com.calyrsoft.ucbp1.features.github.domain.model

import com.calyrsoft.ucbp1.features.github.domain.model.valueObjects.NickName
import com.calyrsoft.ucbp1.features.github.domain.model.valueObjects.UrlPath

data class UserModel(val nickname: NickName, val pathUrl: UrlPath)
