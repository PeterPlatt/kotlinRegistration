package us.pplatt.learning.kotlinregistration.ports.rest

import com.fasterxml.jackson.annotation.JsonCreator
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import us.pplatt.learning.kotlinregistration.ports.persistence.mongo.Message
import us.pplatt.learning.kotlinregistration.ports.persistence.mongo.MessageRegistration
import java.util.*

private val logger = KotlinLogging.logger {}

@RestController
class RegistrationController {

    @Autowired
    lateinit var messageRegistration: MessageRegistration

    @PostMapping("/register")
    fun register(@RequestBody registration: RegistrationModel): Mono<RegistrationId> {
        logger.info { "Request made :$registration"}
        messageRegistration.save(Message(registration.id, registration.message))
        return Mono.just(RegistrationId(registration.id))
    }

    @GetMapping("/id/{messageId}")
    fun getMessageById(@PathVariable(value = "messageId") messageId: UUID): Mono<RegistrationModel> {
        logger.info { "Request made :$messageId"}

        return messageRegistration.findById(messageId).map { RegistrationModel(it.message, it.id) }.toMono()
//                .orElseGet({
//            response.sendError(404, "Response not found")
//            RegistrationModel("", messageId)
//        }
//        )
    }

}

data class RegistrationModel @JsonCreator constructor(val message: String, val id: UUID)
data class RegistrationId @JsonCreator constructor(val id: UUID)



