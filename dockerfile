# Sử dụng JDK 17
FROM eclipse-temurin:21-jdk

# Đặt thư mục làm việc
WORKDIR /app

# Copy file jar vào container
COPY target/korea_app_backend-0.0.1-SNAPSHOT.jar app.jar

# Lệnh chạy app
ENTRYPOINT ["java", "-jar", "app.jar"]
