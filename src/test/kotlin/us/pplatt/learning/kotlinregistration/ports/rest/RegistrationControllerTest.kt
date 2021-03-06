package us.pplatt.learning.kotlinregistration.ports.rest

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import java.util.*
import org.hamcrest.core.Is.`is` as Is

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(EmbeddedMongoAutoConfiguration::class)
class RegistrationControllerTest {


    @Autowired
    lateinit var context: WebApplicationContext

    lateinit var mockMvc: MockMvc
    var objectMapper: ObjectMapper = ObjectMapper()

    @Before
    fun setupMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    @Test
    fun registrationEndpoint() {
        val testMessage = "testMessage"
        val testUUID = UUID.randomUUID()

        val messageRegistration = objectMapper.writeValueAsString(RegistrationModel(testMessage, testUUID))
        mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON).content(messageRegistration))
                .andDo(print())
                .andExpect(jsonPath("$.id", Is(testUUID.toString())))

    }

    @Test
    fun messageEndpointPresent() {
        val testMessage = "testMessage"
        val testUUID = UUID.randomUUID()

        val messageRegistration = objectMapper.writeValueAsString(RegistrationModel(testMessage, testUUID))
        mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON).content(messageRegistration))
                .andDo(print())
                .andExpect(jsonPath("$.id", Is(testUUID.toString())))


        mockMvc.perform(get("/id/" + testUUID.toString()))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(jsonPath("$.id", Is(testUUID.toString())))
                .andExpect(jsonPath("$.message", Is(testMessage)))

        mockMvc.perform(get("/id/" + UUID.randomUUID().toString()))
                .andDo(print())
                .andExpect(status().is4xxClientError)
    }
}
