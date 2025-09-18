package org.korea_app_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvConfig {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private String jwtExpiration;

    public String getJwtSecret() {
        return jwtSecret;
    }

    public String getJwtExpiration() {
        return jwtExpiration;
    }
}
