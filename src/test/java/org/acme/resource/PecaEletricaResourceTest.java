package org.acme.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.acme.dto.DtoEletricaResponse;
import org.acme.dto.DtoEletricaRequest;
import org.acme.services.EletricaServiceImpl;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class PecaEletricaResourceTest {
    @Inject
    EletricaServiceImpl service;



    @Test
    void testIncluir() {
        DtoEletricaRequest peca = new DtoEletricaRequest(
                "bosh",
                "capacitor",
                "120V",
                12);

        given()
                .contentType(ContentType.JSON)
                .body(peca)
                .when().post("/PecaEletrica")
                .then()
                .statusCode(201)
                .body(

                        "id", notNullValue(),
                        "marca", is("bosh"),
                        "nome", is("capacitor"),

                        "voltagem", is("120V"),

                        "estoque", is(12)
                );
    }
    @Test
    void testBuscarNome() {

        DtoEletricaRequest peca = new DtoEletricaRequest("bosh", "capacitor", "120V", 12);
        Long id = service.incluir(peca).id();

        String nomeBusca = "capacitor";


        given()
                .when().get("/PecaEletrica/nome/" + nomeBusca)
                .then()
                .statusCode(200)
                .body("[0].nome", is(nomeBusca))
                .body("[0].marca", is("bosh"))
                .body("[0].voltagem", is("120V"))
                .body("[0].estoque", is(12));
    }
    static Long id = null;

    @Test
    void testAlterar() {
        DtoEletricaRequest eletrica = new DtoEletricaRequest(
                "bosh",
                "modulo_injeção",
                "120V",
                12);

        id =  service.incluir(eletrica).id();

        DtoEletricaRequest eletricaAlterado = new DtoEletricaRequest(
                "Delphi Technologies",
                "central_eletronica",
                "100V",
                10);

        given()
                .contentType(ContentType.JSON)
                .body(eletricaAlterado)
                .when().put("/PecaEletrica/" + id)
                .then()
                .statusCode(204);
        DtoEletricaResponse response = service.findById(id);
        assertThat(response.nome(), is("central_eletronica"));
        assertThat(response.marca(), is("Delphi Technologies"));
        assertThat(response.voltagem(),is("100V"));
        assertThat(response.estoque(), is(10));
    }

    @Test
    void testDelete() {

        DtoEletricaRequest eletrica = new DtoEletricaRequest("marcaTeste", "capacitor_lixo", "120V", 10);
        Long idCriado = service.incluir(eletrica).id();


        given()
                .when().delete("/PecaEletrica/" + idCriado)
                .then()
                .statusCode(204);


        DtoEletricaResponse response = service.findById(idCriado);
        assertNull(response);
    }

}
