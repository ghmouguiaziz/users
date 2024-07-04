package com.keyloak.security.Config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    @Bean
    public Keycloak keycloak() {
        return KeycloakBuilder.builder()
                .serverUrl("http://172.18.131.140:8080")
                .realm("MTCsecurity")
                .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                .clientId("MTC")
                .username("admin")
                .password("admin")
                .clientSecret("HY1rfpjBkmIgqYVEmyLIkcG4ELQekUYV")
                .build();
    }
}
