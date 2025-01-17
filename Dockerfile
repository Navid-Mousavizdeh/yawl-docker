# Use a base image with JDK and Ant
FROM openjdk:11-jdk-slim

# Install a specific version of Ant
RUN apt-get update && apt-get install -y ant && rm -rf /var/lib/apt/lists/*

# Set environment variables
ENV YAWL_HOME=/opt/yawl

# Create a working directory for YAWL
WORKDIR $YAWL_HOME

# Copy the YAWL source code into the container
COPY . $YAWL_HOME

# Navigate to the directory containing build.xml and build the standalone JAR
WORKDIR $YAWL_HOME/build
RUN ant build_controlPanel.jar

# Expose the required ports
EXPOSE 8080 8443

# Run the YAWL engine
CMD ["java", "-jar", "/opt/yawl/output/YawlControlPanel-5.1.jar", "-start"]
