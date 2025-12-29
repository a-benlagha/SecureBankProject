# 1. Use Eclipse Temurin for Java 25
FROM eclipse-temurin:25-jdk

# 2. Set working directory
WORKDIR /app

# 3. Copy the jar
COPY target/SecureBankProject-1.0-SNAPSHOT.jar app.jar

# 4. Run the Main class directly 
ENTRYPOINT ["java", "-cp", "app.jar", "com.dependability.Main"]