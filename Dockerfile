FROM openjdk:11
COPY . /app
WORKDIR /app
RUN ./gradlew build
ENTRYPOINT ["./gradlew","bootRun"]