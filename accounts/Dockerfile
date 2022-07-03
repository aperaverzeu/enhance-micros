FROM amazoncorretto:17.0.3 as build

COPY target/accounts-0.0.1-SNAPSHOT.jar accounts.jar

ENTRYPOINT ["java", "-jar", "/accounts.jar"]