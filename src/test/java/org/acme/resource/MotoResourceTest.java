package org.acme.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.acme.dto.DtoMotorRequest;
import org.acme.dto.DtoMotorResponse;
import org.acme.services.MotorServiceImpl;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


@QuarkusTest
public class MotoResourceTest {
    @Inject
    MotorServiceImpl service;

    @Test
    void testIncluir() {
        DtoMotorRequest motor  = new DtoMotorRequest(
                "V8_BOSS469",
                122.510,
                1l);

        given()
                .contentType(ContentType.JSON)
                .body(motor)
                .when().post("/motor")
                .then()
                .statusCode(201)
                .body(

                        "id", notNullValue(),
                        "nome", is("V8_BOSS469"),
                        "preco", is(122.510f),
                        "carro.id", is(nullValue())
                );
    }
    @Test
    void testBuscarNome() {

        DtoMotorRequest motor = new DtoMotorRequest("V8_BOSS469", 122.510f, 1l);
        Long id = service.incluir(motor).id();

        String nomeBusca = "V8_BOSS469";

        given()
                .when().get("/motor/nome/" + nomeBusca)
                .then()
                .statusCode(200)
                .body("[0].nome", is(nomeBusca))
                .body("[0].preco", is(122.510f))
                .body("[0].idCarro", is(nullValue()));
    }

    static Long id = null;

    @Test
    void testAlterar() {
        DtoMotorRequest motorInicial = new DtoMotorRequest(
                "V8_BOSS469_Temp",
                151.210,
                1L);


        id = service.incluir(motorInicial).id();
        assertNotNull(id, "ID do motor não deveria ser nulo após inclusão inicial");

        // --- Dados para Alteração ---
        DtoMotorRequest motorAlterado = new DtoMotorRequest(
                "V6_BOSS420",
                101.100,
                1l);

        // --- Ação: Chama a API PUT ---
        given()
                .contentType(ContentType.JSON)
                .body(motorAlterado)
                .pathParam("id", id)
                .when().put("/motor/{id}")
                .then()
                .statusCode(204);


        DtoMotorResponse response = service.findById(id);
        assertNotNull(response, "A resposta do findById não deveria ser nula");


        assertThat(response.nome(), is("V6_BOSS420"));

        assertThat(response.preco(), is(closeTo(101.100, 0.001)));

        assertThat(response.carro(), is(nullValue()));
    }



    @Test
    void testDelete() {

        DtoMotorRequest motor = new DtoMotorRequest("V_teste", 120.000,  1l);
        Long idCriado = service.incluir(motor).id();

        given()
                .when().delete("/motor/" + idCriado)
                .then()
                .statusCode(204);

        DtoMotorResponse response = service.findById(idCriado);
        assertNull(response);
    }

}
