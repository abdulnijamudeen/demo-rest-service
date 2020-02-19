package com.example.nizam.app.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MigrationConfig {
    @Bean
    public FlywayMigrationStrategy cleanMigrateStrategy() {

    FlywayMigrationStrategy strategy = new FlywayMigrationStrategy() {

        @Override
        public void migrate(Flyway flyway) {
            flyway.clean();
            flyway.migrate();
            flyway.validate();
        }
    };

    return strategy;
}

}