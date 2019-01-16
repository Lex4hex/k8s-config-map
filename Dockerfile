FROM openjdk:8-jdk-slim
ENV KUBERNETES_NAMESPACE default
ARG JAR_FILE
COPY ${JAR_FILE} /opt/app.jar
WORKDIR /opt
CMD ["java", "-jar", "app.jar"]