package org.acme;

import io.smallrye.mutiny.Uni;
import org.jboss.logging.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/roles")
public class RoleResource {
    private static final Logger LOGGER = Logger.getLogger(RoleResource.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Role> json(Role role) {
        return Uni.createFrom().item(role);
    }


    @POST
    @Consumes("application/x+yaml")
    @Produces("application/x+yaml")
    public Uni<Role> yaml(Role role) {
        return Uni.createFrom().item(role);
    }
}