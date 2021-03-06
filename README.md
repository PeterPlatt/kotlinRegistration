[![Build Status](https://travis-ci.org/PeterPlatt/kotlinRegistration.svg?branch=master)](https://travis-ci.org/PeterPlatt/kotlinRegistration)
# Kotlin Registration
This is a basic application that will test out kotlin and spring integration. The intent of the is to create a rest 
service that will generate a basic UUID and persist a message on mongo for later retrial with the UUID. 

# Setup
1. Setup a mongoDB instance or create one online for free using it's free [Mongo Lab](https://mlab.com/)
1. Set the environment variables listed below to the appropriate values
1. Run the application using the command below 
```
gradle bootRun
```

## Environment variables setup
|Environment Variable  | Description  | Example  |
|---|---|---|
|registrationMongoPassword| Password used for mongodb user   |  pass123  |
|registrationMongoUserName| Username used for mongodb user  | UN123  |
|registrationMongoDatabase| Mongodb database name  | testMongo  |
|registrationMongoHost    | mongodb host  | something.mlab.com  |
|registrationMongoPort    | mongodb port  | 1235  |

# How to run the Tests
The tests use an embedded mongoDb instance and can be run with no external setup. Execute the command below to run the 
test.
```
gradle test
```

# Resources 
* Logging [Kotlin Logging](https://github.com/MicroUtils/kotlin-logging)
* Try Kotlin [kotlin try it](https://try.kotl.in/#/Examples/Hello,%20world!/Simplest%20version/Simplest%20version.kt)
* [jUnit 5, Spring boot , and kotlin](https://objectpartners.com/2016/07/26/junit-5-with-spring-boot-plus-kotlin/)
* [How to build a Simple REST API with Kotlin and Spring Boot](https://scotch.io/@grahamcox82/how-to-build-a-simple-rest-api-with-kotlin-and-spring-boot)
* [Udemy Introduction to Kotlin](https://www.udemy.com/kotlin-java/)
* [Kotlin in Action chapter 1](https://livebook.manning.com/#!/book/kotlin-in-action/chapter-1/1)
