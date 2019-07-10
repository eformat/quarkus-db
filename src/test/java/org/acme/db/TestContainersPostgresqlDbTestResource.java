package org.acme.db;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.acme.db.TestContainersPostgresqlDbTestResource.Initializer;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * TestContainersMariaDbTestResource
 */
@QuarkusTestResource(Initializer.class)
public class TestContainersPostgresqlDbTestResource {

    public static class Initializer implements QuarkusTestResourceLifecycleManager {

        private PostgreSQLContainer postgreSQLContainer;

        @Override
        public Map<String, String> start() {
            this.postgreSQLContainer = new PostgreSQLContainer<>("postgres:10.5");
            this.postgreSQLContainer.start();
            return configurationParameters();
        }

        private Map<String, String> configurationParameters() {
            final Map<String, String> conf = new HashMap<>();
            conf.put("quarkus.datasource.url", this.postgreSQLContainer.getJdbcUrl());
            System.out.println(this.postgreSQLContainer.getJdbcUrl());
            conf.put("quarkus.datasource.username", this.postgreSQLContainer.getUsername());
            conf.put("quarkus.datasource.password", this.postgreSQLContainer.getPassword());
            return conf;
        }

        @Override
        public void stop() {
            if (this.postgreSQLContainer != null) {
                this.postgreSQLContainer.close();
            }
        }
    }
}
