package org.acme.resource;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.dto.DtoPessoaFisica;
import org.acme.services.PessoaFisicaService;

@Path("pessoafisica")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaFisicaResource {
    @Inject
    PessoaFisicaService service;

    @GET
    public Response buscarTodos() {
        return Response.ok().entity(service.findAll()).build();
    }

    @GET
    @Path("/nome/{nome}")
    public Response buscarPorNome(String nome) {
        return Response.ok().entity(service.findByNome(nome)).build();
    }

    @GET
    @Path("/cpf/{cpf}")
    public Response buscarPorSigla(String cpf) {
        return Response.ok().entity(service.findByCpf(cpf)).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorSigla(Long id) {
        return Response.ok().entity(service.findById(id)).build();
    }

    @POST
    public Response incluir(@Valid DtoPessoaFisica dto) {
        return Response.status(Response.Status.CREATED).entity(service.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response alterar(Long id, DtoPessoaFisica dto) {
        service.update(id, dto);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response apagar(Long id) {
        service.delete(id);
        return Response.noContent().build();
    }


}
