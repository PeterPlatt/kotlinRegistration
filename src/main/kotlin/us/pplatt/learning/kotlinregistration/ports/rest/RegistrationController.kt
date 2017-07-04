package us.pplatt.learning.kotlinregistration.ports.rest

import com.fasterxml.jackson.annotation.JsonCreator
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class RegistrationController {

    @RequestMapping("/register", method = arrayOf(RequestMethod.POST))
    fun register(@RequestBody registration: RegistrationModel): RegistrationId {
        return RegistrationId(registration.id)
    }

    @RequestMapping("/id/{messageId}", method = arrayOf(RequestMethod.GET))
    fun getMessageById(@PathVariable(value = "messageId") messageId: UUID): RegistrationModel {
        //TODO: Update with actual values
        return RegistrationModel("sample", messageId)
    }

}

data class RegistrationModel @JsonCreator constructor(val message: String, val id: UUID)
data class RegistrationId @JsonCreator constructor(val id: UUID)



