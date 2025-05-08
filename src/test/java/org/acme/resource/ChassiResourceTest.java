package org.acme.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.acme.dto.DtoChassiRequest;
import org.acme.dto.DtoChassiResponse;
import org.acme.services.ChassiServiceImpl;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;


@QuarkusTest
public class ChassiResourceTest {
    @Inject
    ChassiServiceImpl service;

    @Test
    void testIncluir() {
        DtoChassiRequest servico = new DtoChassiRequest(
                "ABC9977");

        given()
                .contentType(ContentType.JSON)
                .body(servico)
                .when().post("/chassi")
                .then()
                .statusCode(201)
                .body(
                        "id", notNullValue(),
                        "numero", is("ABC9977")
                );
    }
    @Test
    void testBuscarNome() {

        DtoChassiRequest peca = new DtoChassiRequest("BADJAVIO404");
        Long id = service.incluir(peca).id();

        String nomeBusca = "BADJAVIO404";


        given()
                .when().get("/chassi/nome/" + nomeBusca)
                .then()
                .statusCode(200)
                .body("[0].numero", is(nomeBusca));
    }

    static Long id = null;

    @Test
    void testAlterar() {
         DtoChassiRequest chassi = new DtoChassiRequest(
                "ABC7799")
        ;

        id =  service.incluir(chassi).id();

        DtoChassiRequest servicoAlterado = new DtoChassiRequest(
                "chassi_teste");

        given()
                .contentType(ContentType.JSON)
                .body(servicoAlterado)
                .when().put("/chassi/" + id)
                .then()
                .statusCode(204);
        DtoChassiResponse response = service.findById(id);
        assertThat(response.numero(), is("chassi_teste"));
    }

    @Test
    void testDelete() {

        DtoChassiRequest chassi = new DtoChassiRequest("chassi_teste2");
        Long idCriado = service.incluir(chassi).id();

        given()
                .when().delete("/chassi/" + idCriado)
                .then()
                .statusCode(204);

        // Verifica se foi removido
        DtoChassiResponse response = service.findById(idCriado);
        assertNull(response);
    }

}
















