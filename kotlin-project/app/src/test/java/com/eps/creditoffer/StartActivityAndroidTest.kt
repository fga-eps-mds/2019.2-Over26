package com.eps.creditoffer

import com.eps.creditoffer.StartLink
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.result.Result
import org.json.JSONObject

import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.unmockkAll
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith


@ExtendWith(MockKExtension::class)
class StartActivityAndroidTest {

    @RelaxedMockK
    lateinit var startLink: StartLink

    var NAME = "Test"

    @Test
    fun startTest() {
        startLink.start(NAME)
    }
}