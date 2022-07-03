FROM amazoncorretto:17.0.3 as build

COPY target/config-server-0.0.1-SNAPSHOT.jar config-server.jar

ENTRYPOINT ["java", "-jar", "/config-server.jar"]