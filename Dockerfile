FROM alpine
RUN apk -U upgrade; apk add openjdk11-jdk maven git; git clone https://github.com/kourounisgiorgos/FreePass.git;cd FreePass; mvn package -DskipTests;
EXPOSE 8080
CMD ["java", "-jar", "/FreePass/target/freepass-0.0.1-SNAPSHOT.jar"]
