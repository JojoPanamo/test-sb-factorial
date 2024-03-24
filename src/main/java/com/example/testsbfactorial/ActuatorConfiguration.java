package com.example.testsbfactorial;

import io.micrometer.prometheus.PrometheusMeterRegistry;
import io.prometheus.client.CollectorRegistry;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.metrics.export.prometheus.PrometheusScrapeEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActuatorConfiguration {

    @Bean
    public HealthIndicator customHealthIndicator() {
        return () -> Health.status("CUSTOM").build();
    }

    @Bean
    public PrometheusScrapeEndpoint prometheusScrapeEndpoint(PrometheusMeterRegistry prometheusMeterRegistry) {
        CollectorRegistry collectorRegistry = prometheusMeterRegistry.getPrometheusRegistry();
        return new PrometheusScrapeEndpoint(collectorRegistry);
    }

}
