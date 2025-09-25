package com.calyrsoft.ucbp1.features.github.domain.model

import com.calyrsoft.ucbp1.features.github.domain.model.valueObjects.UrlPath
import org.junit.Test

class UrlPathTest {
    @Test(expected = Exception::class)
    fun `Test url path`(){
        UrlPath("")

    }

}