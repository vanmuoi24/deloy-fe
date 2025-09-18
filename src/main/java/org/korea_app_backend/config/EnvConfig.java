package org.korea_app_backend.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

@Component
public class EnvConfig {

    private final Dotenv dotenv;

    public EnvConfig() {
        // Load file .env nằm ở root project
        dotenv = Dotenv.load();
    }

    public String getJwtSecret() {
        return dotenv.get("JWT_SECRET");
    }

    public String getJwtExpiration() {
        return dotenv.get("JWT_EXPIRATION");
    }
}
