package io.github.yuokada;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

@ApplicationScoped
@Path("/api/v1")
public class CallbackResource {

    private final Logger logger;

    @Inject
    public CallbackResource(Logger logger) {
        this.logger = logger;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response callback(String requestBody) {
        logger.debug(requestBody);
        return Response.ok("ok").build();
    }

}
