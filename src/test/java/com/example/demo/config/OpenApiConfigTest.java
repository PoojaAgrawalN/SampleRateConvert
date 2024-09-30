package com.example.demo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for {@link OpenApiConfig}.
 * This class contains unit tests for verifying OpenAPI configuration settings.
 */
class OpenApiConfigTest {

    @Test
    @DisplayName("Verify OpenAPI Information")
    void openApiInfo() {

        // Given
        OpenAPIDefinition openAPIDefinition = OpenApiConfig.class.getAnnotation(OpenAPIDefinition.class);

        // Then
        assertEquals("1.0.0", openAPIDefinition.info().version());
        assertEquals("sample", openAPIDefinition.info().title());

    }

    @Test
    @DisplayName("Verify OpenAPI Contact Information")
    void contactInfo() {

        // Given
        Info info = OpenApiConfig.class.getAnnotation(OpenAPIDefinition.class).info();
        Contact contact = info.contact();

        // Then
        assertEquals("Nagarro", contact.name());
        assertEquals("", contact.url());

    }

}