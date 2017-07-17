package us.pplatt.learning.kotlinregistration.ports.rest

import com.fasterxml.jackson.annotation.JsonCreator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import us.pplatt.learning.kotlinregistration.us.pplatt.learning.kotlinregistration.ports.persistence.mongo.Message
import us.pplatt.learning.kotlinregistration.us.pplatt.learning.kotlinregistration.ports.persistence.mongo.MessageRegistration
import java.util.*
import javax.servlet.http.HttpServletResponse

@RestController
class RegistrationController {

    @Autowired
    var messageRegistration: MessageRegistration? = null

    @RequestMapping("/register", method = arrayOf(RequestMethod.POST))
    fun register(@RequestBody registration: RegistrationModel): RegistrationId {
        messageRegistration?.save(Message(registration.id, registration.message))
        return RegistrationId(registration.id)
    }

    @RequestMapping("/id/{messageId}", method = arrayOf(RequestMethod.GET))
    fun getMessageById(@PathVariable(value = "messageId") messageId: UUID, response: HttpServletResponse): RegistrationModel {
        val findById = messageRegistration?.findById(messageId)

        if (findById != null && findById.isPresent) {
            return RegistrationModel(findById.get().message, findById.get().id)
        }

        response.sendError(404, "Response not found")
        return RegistrationModel("", messageId)
    }

}

data class RegistrationModel @JsonCreator constructor(val message: String, val id: UUID)
data class RegistrationId @JsonCreator constructor(val id: UUID)



