package us.pplatt.learning.kotlinregistration.ports.persistence.mongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.util.*

@Repository
interface MessageRegistration : ReactiveMongoRepository<Message, UUID>

data class Message(@Id val id: UUID = UUID.randomUUID(), val message: String = "", val createdDate: Date = Date.from(ZonedDateTime.now(ZoneOffset.UTC).toInstant()))

