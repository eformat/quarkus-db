package org.acme.db;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import org.acme.db.TestContainersMariaDbTestResource.Initializer;
import org.testcontainers.containers.MariaDBContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * TestContainersMariaDbTestResource
 */
//@QuarkusTestResource(Initializer.class)
public class TestContainersMariaDbTestResource {

    public static class Initializer implements QuarkusTestResourceLifecycleManager {

        private MariaDBContainer mariaDBContainer;

        @Override
        public Map<String, String> start() {
            this.mariaDBContainer = new MariaDBContainer<>("mariadb:10.4.4");
            this.mariaDBContainer.start();
            return configurationParameters();
        }

        private Map<String, String> configurationParameters() {
            final Map<String, String> conf = new HashMap<>();
            conf.put("quarkus.datasource.url", this.mariaDBContainer.getJdbcUrl());
            System.out.println(this.mariaDBContainer.getJdbcUrl());
            conf.put("quarkus.datasource.username", this.mariaDBContainer.getUsername());
            conf.put("quarkus.datasource.password", this.mariaDBContainer.getPassword());
            return conf;
        }

        @Override
        public void stop() {
            if (this.mariaDBContainer != null) {
                this.mariaDBContainer.close();
            }
        }
    }
}
