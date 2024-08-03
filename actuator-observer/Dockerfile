# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim


# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the target directory of your project into the container
# Replace 'your-app.jar' with the actual name of your JAR file
COPY target/demo-actuator-0.0.1-SNAPSHOT.jar /app/

# Expose the port that the application will run on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/demo-actuator-0.0.1-SNAPSHOT.jar"]

