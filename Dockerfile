FROM openjdk:12-alpine

COPY target/houshaltsbuche-*.jar /houshaltsbuche.jar

CMD ["java" , "-jar" , "/houshaltsbuche.jar"]