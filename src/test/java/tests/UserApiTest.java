package tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void deveBuscarUsuarioComSucesso() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/users/2")
        .then()
            .statusCode(200)
            .body("data.id", equalTo(2))
            .body("data.email", equalTo("janet.weaver@reqres.in"))
            .body("data.first_name", equalTo("Janet"));
    }

    @Test
    public void deveCriarUsuarioComSucesso() {
        String corpoRequisicao = "{"
                + "\"name\": \"Dyenifer\","
                + "\"job\": \"QA Engineer\""
                + "}";

        given()
            .contentType(ContentType.JSON)
            .body(corpoRequisicao)
        .when()
            .post("/users") 
        .then()
            .statusCode(201) 
            .body("name", equalTo("Dyenifer"))
            .body("job", equalTo("QA Engineer"))
            .body("id", notNullValue());
    }
}
