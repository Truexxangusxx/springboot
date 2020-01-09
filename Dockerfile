FROM openjdk:8
RUN mkdir -p /app
COPY ./build/libs/demo2-0.0.1-SNAPSHOT.jar /app
WORKDIR /app
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "demo2-0.0.1-SNAPSHOT.jar" ]