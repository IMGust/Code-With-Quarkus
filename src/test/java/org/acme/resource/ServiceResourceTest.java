package org.acme.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.acme.dto.DtoServicoRequest;
import org.acme.dto.DtoServicoResponse;
import org.acme.services.ServicoServiceImpl;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class ServiceResourceTest {

    @Inject
    ServicoServiceImpl service;

    @Test
    void testIncluir() {
        DtoServicoRequest servico = new DtoServicoRequest(
                "lava_jato");

        given()
                .contentType(ContentType.JSON)
                .body(servico)
                .when().post("/servico")
                .then()
                .statusCode(201)
                .body(
                        "id", notNullValue(),
                        "nome", is("lava_jato")
                );
    }

    static Long id = null;

    @Test
    void testAlterar() {
        DtoServicoRequest servico = new DtoServicoRequest(
                "lava_jato");

        id =  service.incluir(servico).id();

       DtoServicoRequest servicoAlterado = new DtoServicoRequest(
                "pintura");

        given()
                .contentType(ContentType.JSON)
                .body(servicoAlterado)
                .when().put("/servico/" + id)
                .then()
                .statusCode(204);
        DtoServicoResponse response = service.findById(id);
        MatcherAssert.assertThat(response.nome(), is("pintura"));
    }

    @Test
    void testDelete() {

        DtoServicoRequest servico = new DtoServicoRequest("servico_teste");
        Long idCriado = service.incluir(servico).id();

        given()
                .when().delete("/servico/" + idCriado)
                .then()
                .statusCode(204);

        // Verifica se foi removido
        DtoServicoResponse response = service.findById(idCriado);
       assertNull(response);
    }

}



















