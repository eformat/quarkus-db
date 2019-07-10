package org.acme.db;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestMethodOrder(OrderAnnotation.class)
public class DeveloperResourceTest {

    @Test
    @Order(1)
    public void testPostDeveloperEndpoint() {
        given()
                .header("Content-Type", "application/json")
                .body("{\"name\": \"Mike\"}")
                .when()
                .post("/developer")
                .then()
                .assertThat()
                .statusCode(201);
    }

    @Test
    @Order(2)
    public void testGetDevelopmentEndpoint() {
        given()
                .when().get("/developer/Mike")
                .then()
                .statusCode(200)
                .body("name", is("Mike"));
    }

}
