# Microservices

JGMP 2022 Task 11
-----------------
How to Package and Build docker Images
---------------------------
In system command prompt use maven command inside the root directory of project 'micro-services'
`mvn clean package docker:build`. There will be generated JAR packages of all necessary projects.


And Run microservices in Docker Containers
-----------
Continue typing in command prompt
`docker-compose up -d`

What you should see then?
----------
In a browser will be `'TWO says: 'Hello from 'ONE'!'` on url http://localhost:8765/api/get-greeting
It means that your GET request went to a service `apigateway`, which had already asked service
`discovery` about what is the host name serving such requests, and will be forwarded to service `one`. Service `one`
reply the request, and it's response went back in the same way.