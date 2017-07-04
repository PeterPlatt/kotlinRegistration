package us.pplatt.learning.kotlinregistration

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinRegistrationApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinRegistrationApplication::class.java, *args)
}
