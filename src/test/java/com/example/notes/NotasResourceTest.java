package com.example.notes;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class NotasResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/notas")
          .then()
             .statusCode(200)
             .body(is("Hello from RESTEasy Reactive"));
    }

}