package com.example.testsbfactorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HealthCheckIntegrationTest {

    @Autowired
    private HealthIndicator customHealthIndicator;

    @Test
    public void healthEndpointShouldReturnStatusUp() {
        Health health = customHealthIndicator.health();
        assertThat(health.getStatus()).isEqualTo(Health.status("CUSTOM").build().getStatus());
    }
}