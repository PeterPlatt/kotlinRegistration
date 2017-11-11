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
|registrationMongoHost    | mongodb host  |   |
|registrationMongoPort    | mongodb port  |   |

# How to run the Tests
The tests use an embedded mongoDb instance and can be run with no external setup. Execute the command below to run the 
test.


# Resources 
* Logging [Kotlin Logging](https://github.com/MicroUtils/kotlin-logging)