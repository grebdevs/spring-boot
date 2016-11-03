# Spring Boot with JMS/ActiveMQ

This project aims to provide a simple web interface from which it is possible to publish and subscribe messages to
arbitrary queues on an Apache ActiveMQ broker.

The frontend is based on AngularJS. The backend is Spring Boot with JMS. A REST interface is used to pass information between frontend and backend.

To run it, start your local ActiveMQ and then run
```mvn clean install spring-boot:run```