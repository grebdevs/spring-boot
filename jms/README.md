# Spring Boot with JMS/ActiveMQ

This project aims to provide a simple web interface from which it is possible to publish and subscribe messages to
arbitrary queues on an Apache ActiveMQ broker.

The frontend is based on AngularJS. The backend is Spring Boot with JMS. A REST interface is used to pass information
between frontend and backend.

To run it, start a local ActiveMQ and then run
```mvn clean install spring-boot:run```

Alternatively, testing can be done using Docker. This simplifies testing of multiple simultaneous instances.
Running ```docker-compose up``` will start an ActiveMQ server and two instances of the JMS web client,
at port 8080 and 8081 respectively.