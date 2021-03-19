
# Step : Create dirs
FROM openjdk:8-alpine
WORKDIR /home/hellocode/services/temp-converter

#Step : cpty data
COPY ./build/libs .
COPY ./src/main/resources .
EXPOSE 80
ENTRYPOINT  ["java" ,"-jar","temp-converter.jar", "--spring.config.location=application.properties"]