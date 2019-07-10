package org.acme.db;

import org.osgi.annotation.versioning.ConsumerType;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/developer")
public class DeveloperResource {

    @Context
    UriInfo UriInfo;

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer findDev(@PathParam("name") String name) {
        return Developer.find("name", name).singleResult();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDev(Developer developer) {
        developer.persist();
        System.out.println("Added: " + developer);
        return Response.created(
                UriInfo.getBaseUriBuilder()
                        .path(Long.toString(developer.id))
                        .build())
                .build();
    }

}
