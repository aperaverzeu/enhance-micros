FROM amazoncorretto:17.0.3 as build

COPY target/loans-0.0.1-SNAPSHOT.jar loans.jar

ENTRYPOINT ["java", "-jar", "/loans.jar"]