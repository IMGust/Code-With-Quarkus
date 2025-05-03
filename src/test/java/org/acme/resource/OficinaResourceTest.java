package org.acme.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.acme.dto.DtoOficina;
import org.acme.dto.DtoOficinaNome;
import org.acme.dto.DtoOficinaResponse;
import org.acme.dto.DtoRequestServico;
import org.acme.services.OficinaServiceImpl;
import org.acme.services.ServicoServiceImpl;
import org.junit.jupiter.api.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static io.smallrye.common.constraint.Assert.assertNotNull;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertNull;

@QuarkusTest
public class OficinaResourceTest {

    @Inject
    OficinaServiceImpl service;

    @Inject
    ServicoServiceImpl servicoService;

    @Test
    void testIncluir() {
        DtoRequestServico servico1 = new DtoRequestServico("Troca de óleo");
        Long idServico1 = servicoService.incluir(servico1).id();

        DtoRequestServico servico2 = new DtoRequestServico("Alinhamento de rodas");
        Long idServico2 = servicoService.incluir(servico2).id();

        DtoRequestServico servico3 = new DtoRequestServico("Troca de pneus");
        Long idServico3 = servicoService.incluir(servico3).id();


        DtoOficina oficina = new DtoOficina(
                "oficinaguh",
                "taquaralto",
                List.of(idServico1, idServico2, idServico3)
        );

        given()
                .contentType(ContentType.JSON)
                .body(oficina)
                .when().post("/oficina")
                .then()
                .statusCode(201)
                .body(
                        "id", notNullValue(),
                        "nome", is("oficinaguh"),
                        "endereco", is("taquaralto"),
                        "servicosIds[0]", is(idServico1.intValue()),
                        "servicosIds[1]", is(idServico2.intValue()),
                        "servicosIds[2]", is(idServico3.intValue())
                );
    }


    @Test
    void testBuscarNome() {

        DtoRequestServico servico1 = new DtoRequestServico("Serviço 1");
        Long idServico1 = servicoService.incluir(servico1).id();

        DtoRequestServico servico2 = new DtoRequestServico("Serviço 2");
        Long idServico2 = servicoService.incluir(servico2).id();

        DtoRequestServico servico3 = new DtoRequestServico("Serviço 3");
        Long idServico3 = servicoService.incluir(servico3).id();


        DtoOficina oficina = new DtoOficina(
                "oficinajanio",
                "unitins",
                List.of(idServico1, idServico2, idServico3)
        );

        Long idOficina = service.incluir(oficina).id();

        String nomeBusca = "oficinajanio";

        given()
                .when().get("/oficina/nome/" + nomeBusca)
                .then()
                .statusCode(200)
                .body("[0].nome", is(nomeBusca))
                .body("[0].endereco", is("unitins"))
                .body("[0].servicosIds", hasItems(idServico1.intValue(), idServico2.intValue(), idServico3.intValue()));  // Verificando os IDs dos serviços
    }

    static Long id = null;

    @Test
    void testAlterar() {

        DtoRequestServico servico1 = new DtoRequestServico("Serviço 1");
        DtoRequestServico servico2 = new DtoRequestServico("Serviço 2");
        DtoRequestServico servico3 = new DtoRequestServico("Serviço 3");

        Long servicoId1 = servicoService.incluir(servico1).id();
        Long servicoId2 = servicoService.incluir(servico2).id();
        Long servicoId3 = servicoService.incluir(servico3).id();


        DtoOficina oficina = new DtoOficina(
                "oficinabuh", // Nome
                "bela_vista", // Endereço
                List.of(servicoId1, servicoId2)
        );


        Long id = service.incluir(oficina).id();


        DtoOficina oficinaAlterada = new DtoOficina(
                "oficinaguh",
                "taquaralto",
                List.of(servicoId1, servicoId2, servicoId3)
        );


        given()
                .contentType(ContentType.JSON)
                .body(oficinaAlterada)
                .when().put("/oficina/" + id)
                .then()
                .statusCode(204);


        DtoOficinaResponse response = service.findById(id);


        assertThat(response.nome(), is("oficinaguh"));
        assertThat(response.endereco(), is("taquaralto"));
        assertThat(response.servicosIds(), hasItems(servicoId1, servicoId2, servicoId3));
    }

    @Test
    void testDelete() {

        DtoRequestServico servico1 = new DtoRequestServico("Serviço 1");
        DtoRequestServico servico2 = new DtoRequestServico("Serviço 2");
        DtoRequestServico servico3 = new DtoRequestServico("Serviço 3");
        DtoRequestServico servico4 = new DtoRequestServico("Serviço 4");
        DtoRequestServico servico5 = new DtoRequestServico("Serviço 5");


        Long servicoId1 = servicoService.incluir(servico1).id();
        Long servicoId2 = servicoService.incluir(servico2).id();
        Long servicoId3 = servicoService.incluir(servico3).id();
        Long servicoId4 = servicoService.incluir(servico4).id();
        Long servicoId5 = servicoService.incluir(servico5).id();


        DtoOficina oficina = new DtoOficina(
                "oficina_delete",
                "falling",
                List.of(servicoId1, servicoId2, servicoId4, servicoId5)
        );


        Long idCriado = service.incluir(oficina).id();


        given()
                .when().delete("/oficina/" + idCriado)
                .then()
                .statusCode(204);


        DtoOficinaResponse response = service.findById(idCriado);
        assertNull(response);
    }

    @Test
    void testBuscarPorId() {

        DtoRequestServico servico1 = new DtoRequestServico("Serviço 1");
        DtoRequestServico servico2 = new DtoRequestServico("Serviço 2");


        Long servicoId1 = servicoService.incluir(servico1).id();
        Long servicoId2 = servicoService.incluir(servico2).id();


        DtoOficina oficina = new DtoOficina(
                "oficina_busca",
                "centro",
                List.of(servicoId1, servicoId2)
        );


        Long idCriado = service.incluir(oficina).id();


        DtoOficinaResponse response = service.buscarPorId(idCriado);


        assertNotNull(response);
        assertThat(response.id(), is(idCriado));
        assertThat(response.nome(), is("oficina_busca"));
        assertThat(response.endereco(), is("centro"));
        assertThat(response.servicosIds(), containsInAnyOrder(servicoId1, servicoId2));
    }

    @Test
    void testBuscarPorServico() {

        String nomeServico = "Troca de Óleo";
        DtoRequestServico servico = new DtoRequestServico(nomeServico);
        Long servicoId = servicoService.incluir(servico).id();

        DtoOficina oficina1 = new DtoOficina("Oficina A", "Centro", List.of(servicoId));
        DtoOficina oficina2 = new DtoOficina("Oficina B", "Sul", List.of(servicoId));
        service.incluir(oficina1);
        service.incluir(oficina2);

        List<DtoOficinaNome> resultado = service.buscarPorServico(nomeServico);

        assertNotNull(resultado);
        assertThat(resultado.size(), is(2));
        List<String> nomes = resultado.stream().map(DtoOficinaNome::nome).toList();
        assertThat(nomes, containsInAnyOrder("Oficina A", "Oficina B"));
    }















}