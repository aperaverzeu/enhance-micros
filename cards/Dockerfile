FROM amazoncorretto:17.0.3 as build

COPY target/cards-0.0.1-SNAPSHOT.jar cards.jar

ENTRYPOINT ["java", "-jar", "/cards.jar"]