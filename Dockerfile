FROM openjdk:11-jdk
COPY target/FreePass.jar FreePass.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/FreePass.jar"]
