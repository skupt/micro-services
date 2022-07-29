# Microservices

JGMP 2022 Task 11
-----------------
How to Package and Build docker Images
---------------------------
You should have a docker and docker-compose on your machine to proceed. Besides above, pull 2 docker images to be able
to run docker-compose later:
`docker pull openzipkin/zipkin`
`docker pull graphiteapp/graphite-statsd`
In system command prompt use maven command inside the root directory of project 'micro-services'
`mvn clean package docker:build`. There will be generated JAR packages of all necessary projects.


And Run microservices in Docker Containers
-----------
Continue typing in command prompt being located in root of project
`docker-compose up -d`

What you should see then?
----------
In a browser will be `'TWO says: 'Hello from 'ONE'!'` on url http://localhost:8765/api/get-greeting
It means that your GET request went to a service `apigateway`, which had already asked service
`discovery` about what is the host name serving such requests, and will be forwarded to service `two`. Meanwhile,
service `two` is not a simple rest service, but it is rest-service consumer. It acted as `feign client` and asked
service `one` - a real rest service endpoint. Service `one` then replied the request, and it's response went back in
reverse order of the same way.