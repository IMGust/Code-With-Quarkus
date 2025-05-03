package org.acme.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.acme.dto.DtoCarroRequest;
import org.acme.dto.DtoCarroResponse;
import org.acme.dto.DtoOficina;
import org.acme.dto.DtoRequestServico;
import org.acme.repository.ChassiRepository;
import org.acme.services.CarroServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class CarroResourceTest {

    @Inject
    ChassiRepository repository;
    @Inject
    CarroServiceImpl service;

    @Test
    void testIncluir() {
        DtoCarroRequest carro = new DtoCarroRequest(
                "Ford Mustang",
                "S+",
                3,
                1l);

        given()
                .contentType(ContentType.JSON)
                .body(carro)
                .when().post("/carro")
                .then()
                .statusCode(201)
                .body(
                        "id", notNullValue(),
                        "nome", is("Ford Mustang"),
                        "classificacao", is("S+"),
                        "chassiId", is(nullValue())
                );
    }

    static Long id = null;

    @Test
    void testAlterar() {
        DtoCarroRequest carroRequest = new DtoCarroRequest(
                "Ford Mustang",
                "S+",
                3,
                1l);

        id = service.incluir(carroRequest).id();

        DtoCarroRequest carroAlterado = new DtoCarroRequest(
                "Ford Shelby",
                "S++",
                3,
                1l
        );

        given()
                .contentType(ContentType.JSON)
                .body(carroAlterado)
                .when().put("/carro/" + id)
                .then()
                .statusCode(204);

        DtoCarroResponse response = service.findById(id);
        assertThat(response.nome(), is("Ford Shelby"));
        assertThat(response.classificacao(), is("S++"));
    }

    @Test
    void testDelete() {

        DtoCarroRequest carroRequest = new DtoCarroRequest("Camaro_test", "B+", 2, 1l);
        Long idCriado = service.incluir(carroRequest).id();

        given()
                .when().delete("/carro/" + idCriado)
                .then()
                .statusCode(204);

        DtoCarroResponse carroResponse = service.findById(idCriado);
        assertNull(carroResponse);

    }

    @Test
    void testBuscarNome() {

        DtoCarroRequest carro = new DtoCarroRequest("Ford Maverick", "C", 3, 1l);
        Long id = service.incluir(carro).id();

        String nomeBusca = "Ford Maverick";

        given()
                .when().get("/carro/nome/" + nomeBusca)
                .then()
                .statusCode(200)
                .body("[0].nome", is(nomeBusca))
                .body("[0].classificacao", is("C"))
                .body("[0].chassiId", is(nullValue()));
    }

}





















//    static Long id = null;
//
//    @Test
//    void testAlterar() {
//
//
//
//       DtoCarroRequest carroInicial = new DtoCarroRequest(
//                "V8_BOSS469_Temp",
//                3,
//                1L);
//
//        id = service.incluir(carroInicial).id();
//        assertNotNull(id, "ID do motor não deveria ser nulo após inclusão inicial");
//
//        // --- Dados para Alteração ---
//        DtoCarroRequest carroAlterado = new DtoCarroRequest(
//                "V6_BOSS420",
//                1,
//                1l);
//
//        // --- Ação: Chama a API PUT ---
//        given()
//                .contentType(ContentType.JSON)
//                .body(carroAlterado)
//                .pathParam("id", id)
//                .when().put("/carro/{id}")
//                .then()
//                .statusCode(204);
//
//
//        DtoCarroResponse response = service.findById(id);
//        assertNotNull(response, "A resposta do findById não deveria ser nula");
//
//
//        assertThat(response.nome(), is("V6_BOSS420"));
//
//        assertThat(response.motor(), is(nullValue()));
//
//        assertThat(response.chassi(), is(nullValue()));
//    }
//    @Test
//    void testDelete() {
//
//
//        DtoCarroRequest carroRequest = new DtoCarroRequest("V_teste", 3,  1l);
//        Long idCriado = service.incluir(carroRequest).id();
//
//        given()
//                .when().delete("/carro/" + idCriado)
//                .then()
//                .statusCode(204);
//
//        DtoCarroResponse carroResponse = service.findById(idCriado);
//        assertNull(carroResponse);
//
//    }


