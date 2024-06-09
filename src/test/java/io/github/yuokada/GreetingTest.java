package io.github.yuokada;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class GreetingTest {

    @Test
    void plus2objects() {
        assertThat("123456789010", containsString("10"));
    }

    @Test
    @Disabled
    public void testCallback() {
        String requestBody = "\"Hello World 123\"";
        RestAssured
            .given()
            .contentType(ContentType.JSON)
            //.header("X-Line-Signature", "foo bar")
            .body(requestBody)
            .when().post("/")
            .then()
            .contentType("application/json")
            .body(containsString("X-Line-Signature header is required"));
    }

    @Test
    @Disabled
    public void testCallbackWithEmptyHeader() {
        String requestBody = "\"Hello World 123\"";
        RestAssured
            .given()
            .contentType(ContentType.JSON)
            .header("X-Line-Signature", "")
            .body(requestBody)
            .when().post("/")
            .then()
            .contentType("application/json")
            .body(containsString("X-Line-Signature header is empty"));
    }
}
