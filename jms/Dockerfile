FROM hypriot/rpi-java
VOLUME /tmp
ADD spring-jms-activemq-0.0.1.jar /opt/spring-jms-activemq-0.0.1.jar
#RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/spring-jms-activemq-0.0.1.jar"]