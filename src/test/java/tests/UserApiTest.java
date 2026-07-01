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
        // Define a URL base da API que vamos testar
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    public void deveBuscarUsuarioComSucesso() {
        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/users/2") // Busca o usuário de ID 2
        .then()
            .statusCode(200) // Valida se o status retornado é 200 (OK)
            .body("data.id", equalTo(2)) // Valida se o ID no corpo é 2
            .body("data.email", equalTo("janet.weaver@reqres.in")) // Valida o e-mail
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
            .post("/users") // Envia um POST para criar o usuário
        .then()
            .statusCode(201) // Valida se foi criado com sucesso (201 Created)
            .body("name", equalTo("Dyenifer"))
            .body("job", equalTo("QA Engineer"))
            .body("id", notNullValue()); // Garante que a API gerou um ID
    }
}
